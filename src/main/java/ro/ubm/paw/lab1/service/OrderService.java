package ro.ubm.paw.lab1.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.ubm.paw.lab1.notificare.NotificationService;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class OrderService {
    private final NotificationService notificareStandard;
    private final NotificationService notificareUrgenta;
    private final Clock clock;
    private final String textMesaj;

    public OrderService(NotificationService notificareStandard,
                        @Qualifier("sms") NotificationService notificareUrgenta,
                        Clock clock,
                        @Value("${app.mesaj.comanda}") String textMesaj) {
        this.notificareStandard = notificareStandard;
        this.notificareUrgenta = notificareUrgenta;
        this.clock = clock;
        this.textMesaj = textMesaj;
    }

    public String plaseazaComanda(String client, boolean urgenta) {
        String data = LocalDateTime.now(clock).withNano(0).toString();
        String mesajFinal = textMesaj + " " + data;

        return urgenta 
                ? notificareUrgenta.send(client, mesajFinal) 
                : notificareStandard.send(client, mesajFinal);
    }
}
