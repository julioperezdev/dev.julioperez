package dev.julioperez.certificate.pdfCertificate.infrastructure.delivery;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.PersistStudentCertificateDelivery;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.StudentCertificateEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/pdf")
@AllArgsConstructor
@Slf4j
public class PdfGeneratedHttpController {

    private final PersistStudentCertificateDelivery persistStudentCertificateDelivery;

    @GetMapping("/retrieve")
    public void getPdfStudentCourse(){
        log.info("executing controller to get pdf by student course");
        StudentCertificateEvent studentCertificateEvent = new StudentCertificateEvent(UUID.randomUUID(),"Java Course", UUID.randomUUID(), "Joe Miller");
        persistStudentCertificateDelivery.persistStudentCertificate(studentCertificateEvent);
        log.info("finalize controller to get pdf by student course");
    }
}
