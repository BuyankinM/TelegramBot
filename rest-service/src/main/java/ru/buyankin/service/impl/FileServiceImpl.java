package ru.buyankin.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.buyankin.dao.AppDocumentDAO;
import ru.buyankin.dao.AppPhotoDAO;
import ru.buyankin.entity.AppDocument;
import ru.buyankin.entity.AppPhoto;
import ru.buyankin.service.FileService;
import ru.buyankin.utils.CryptoTool;

@Log4j
@Service
public class FileServiceImpl implements FileService {

    private final AppDocumentDAO appDocumentDAO;
    private final AppPhotoDAO appPhotoDAO;
    private final CryptoTool cryptoTool;

    @Autowired
    public FileServiceImpl(AppDocumentDAO appDocumentDAO, AppPhotoDAO appPhotoDAO, CryptoTool cryptoTool) {
        this.appDocumentDAO = appDocumentDAO;
        this.appPhotoDAO = appPhotoDAO;
        this.cryptoTool = cryptoTool;
    }

    @Override
    public AppDocument getDocument(String docId) {
        var id = cryptoTool.idOf(docId);
        if (id == null) {
            return null;
        }
        return appDocumentDAO.findById(id).orElse(null);
    }

    @Override
    public AppPhoto getPhoto(String photoId) {
        var id = cryptoTool.idOf(photoId);
        if (id == null) {
            return null;
        }
        return appPhotoDAO.findById(id).orElse(null);
    }
}
