package ru.buyankin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buyankin.entity.AppUser;

import java.util.Optional;

public interface AppUserDAO extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByTelegramUserId(long Id);
    Optional<AppUser> findById(long Id);
    Optional<AppUser> findByEmail(String email);
}
