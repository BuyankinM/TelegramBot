package ru.buyankin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buyankin.entity.AppDocument;

public interface AppDocumentDAO extends JpaRepository<AppDocument, Long> {
}
