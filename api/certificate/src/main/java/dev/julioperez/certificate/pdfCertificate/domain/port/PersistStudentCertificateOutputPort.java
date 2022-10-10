package dev.julioperez.certificate.pdfCertificate.domain.port;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;

public interface PersistStudentCertificateOutputPort {

    void persistStudentCertificate(StudentCertificate studentCertificate);
}
