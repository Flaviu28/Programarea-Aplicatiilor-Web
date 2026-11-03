package ro.ubm.paw.lab1.notificare;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public String send(String destinatar, String mesaj) {
        return "[EMAIL Echipamente Fitness] catre " + destinatar + ": " + mesaj;
    }
}
