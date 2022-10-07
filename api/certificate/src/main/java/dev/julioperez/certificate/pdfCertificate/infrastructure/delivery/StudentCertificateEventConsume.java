package dev.julioperez.certificate.pdfCertificate.infrastructure.delivery;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.PersistStudentCertificateDelivery;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class StudentCertificateEventConsume {

    private final PersistStudentCertificateDelivery persistStudentCertificateDelivery;

    @RabbitListener(queues = {"${julioperezdev.queue.name}"})
    public void receive(@Payload StudentCertificateEvent studentCertificateEvent){
        log.info("Receiving message:    {}", studentCertificateEvent);
        persistStudentCertificateDelivery.persistStudentCertificate(studentCertificateEvent);

    }
}
