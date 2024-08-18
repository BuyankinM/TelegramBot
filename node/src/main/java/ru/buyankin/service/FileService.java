package ru.buyankin.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.buyankin.entity.AppDocument;
import ru.buyankin.entity.AppPhoto;
import ru.buyankin.service.enums.LinkType;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);
    String generateLink(Long docId, LinkType linkType);
}
