package ru.buyankin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buyankin.entity.AppUser;

public interface AppUserDAO extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByTelegramUserId(long Id);
}
