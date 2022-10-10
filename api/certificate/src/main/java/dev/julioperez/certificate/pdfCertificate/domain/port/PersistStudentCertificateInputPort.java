package dev.julioperez.certificate.pdfCertificate.domain.port;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.StudentCertificateEvent;


public interface PersistStudentCertificateInputPort {

    void persistStudentCertificate(StudentCertificateEvent studentCertificateEvent);
}
