package ru.buyankin.service;

import ru.buyankin.entity.AppUser;

public interface AppUserService {
    String registerUser(AppUser appUser);
    String sendEmail(AppUser appUser, String email);
}
