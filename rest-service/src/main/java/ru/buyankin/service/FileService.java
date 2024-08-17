package ru.buyankin.service;

import org.springframework.core.io.FileSystemResource;
import ru.buyankin.entity.AppDocument;
import ru.buyankin.entity.AppPhoto;
import ru.buyankin.entity.BinaryContent;

public interface FileService {
    AppDocument getDocument(String id);

    AppPhoto getPhoto(String id);

    FileSystemResource getFileSystemResource(BinaryContent binaryContent);
}
