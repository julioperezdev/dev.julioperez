package dev.julioperez.certificate.pdfCertificate.domain.port;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;

public interface StudentCertificateMapper {
    StudentCertificateEntity toStudentCertificateEntity(StudentCertificateEvent studentCertificateEvent);
}
