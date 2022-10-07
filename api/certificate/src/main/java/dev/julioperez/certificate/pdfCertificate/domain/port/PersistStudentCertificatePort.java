package dev.julioperez.certificate.pdfCertificate.domain.port;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;


public interface PersistStudentCertificatePort {

    void saveStudentCertificate(StudentCertificateEvent studentCertificateEvent);
}
