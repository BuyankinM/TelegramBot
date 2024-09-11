package ru.buyankin.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.buyankin.dao.AppUserDAO;
import ru.buyankin.dto.MailParams;
import ru.buyankin.entity.AppUser;
import ru.buyankin.entity.enums.UserState;
import ru.buyankin.service.AppUserService;
import ru.buyankin.utils.CryptoTool;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Log4j
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDAO appUserDAO;
    private final CryptoTool cryptoTool;

    @Value("${service.mail.uri}")
    private String mailServiveUri;

    @Autowired
    public AppUserServiceImpl(AppUserDAO appUserDAO, CryptoTool cryptoTool) {
        this.appUserDAO = appUserDAO;
        this.cryptoTool = cryptoTool;
    }

    @Override
    public String registerUser(AppUser appUser) {
        if (appUser.getIsActive()) {
            return "Вы уже зарегистрированы!";
        } else if (appUser.getEmail() != null) {
            return "Вам на почту уже было отправлено письмо!"
                    + "Перейти по ссылке в письме для подтверждения регистрации.";
        }
        appUser.setState(UserState.WAITING_FOR_EMAIL_STATE);
        appUserDAO.save(appUser);
        return "Введите, пожалуйста, ваш e-mail:";
    }

    @Override
    public String sendEmail(AppUser appUser, String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            return "Введите, пожалуйста, корректный e-mail. Для отмены команды введите /email";
        }
        var optional = appUserDAO.findByEmail(email);
        if (optional.isEmpty()) {
            appUser.setEmail(email);
            appUser.setState(UserState.BASIC_STATE);

            AppUser user = appUserDAO.save(appUser);
            String cryptoUserId = cryptoTool.hashOf(appUser.getId());
            var responce = sendRequestToMailService(cryptoUserId, email);
            if (responce.getStatusCode() != HttpStatus.OK) {
                var msg = String.format("Отправка эл. письма на почту %s не удалась", email);
                log.error(msg);

                appUser.setEmail(null);
                appUserDAO.save(appUser);
                return msg;
            }
            return "Вам на почту уже было отправлено письмо!"
                    + "Перейти по ссылке в письме для подтверждения регистрации.";
        } else {
            return "Этот email уже используется. Введите корректный email."
                    + "Для отмены команды введите /email";

        }
    }

    private ResponseEntity<String> sendRequestToMailService(String cryptoUserId, String email) {
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        var mailParams = MailParams.builder()
                .id(cryptoUserId)
                .emailTo(email)
                .build();

        var request = new HttpEntity<>(mailParams, headers);
        return restTemplate.exchange(mailServiveUri,
                HttpMethod.POST,
                request,
                String.class);
    }
}
