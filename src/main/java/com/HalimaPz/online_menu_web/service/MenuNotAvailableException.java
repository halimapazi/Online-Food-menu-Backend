package com.HalimaPz.online_menu_web.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuNotAvailableException extends RuntimeException {

    public MenuNotAvailableException(String message) {
        super(message);
    }

}