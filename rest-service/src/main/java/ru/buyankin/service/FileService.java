package ru.buyankin.service;

import ru.buyankin.entity.AppDocument;
import ru.buyankin.entity.AppPhoto;

public interface FileService {
    AppDocument getDocument(String id);

    AppPhoto getPhoto(String id);
}
