package ro.ubm.paw.lab1.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResursaNegasitaException extends RuntimeException {
    public ResursaNegasitaException(String mesaj) {
        super(mesaj);
    }
}
