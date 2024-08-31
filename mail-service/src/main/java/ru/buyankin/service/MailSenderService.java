package ru.buyankin.service;

import ru.buyankin.dto.MailParams;

public interface MailSenderService {
    void send(MailParams mailParams);
}
