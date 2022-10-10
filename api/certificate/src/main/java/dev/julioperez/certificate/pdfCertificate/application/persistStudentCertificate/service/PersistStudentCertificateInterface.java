package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;

public interface PersistStudentCertificateInterface {
    void persistStudentCertificate(StudentCertificate studentCertificate);
}
