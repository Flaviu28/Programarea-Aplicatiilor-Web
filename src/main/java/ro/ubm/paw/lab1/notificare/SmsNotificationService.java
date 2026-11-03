package ro.ubm.paw.lab1.notificare;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsNotificationService implements NotificationService {
    @Override
    public String send(String destinatar, String mesaj) {
        return "[SMS Urgent Fitness] catre " + destinatar + ": " + mesaj;
    }
}
