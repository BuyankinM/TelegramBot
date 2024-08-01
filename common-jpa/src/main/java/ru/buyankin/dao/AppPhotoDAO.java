package ru.buyankin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buyankin.entity.AppPhoto;

public interface AppPhotoDAO extends JpaRepository<AppPhoto, Long> {
}
