package ru.buyankin.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.buyankin.entity.AppDocument;

public interface FileService {
    AppDocument processDoc(Message externalMessage);
}
