package dev.julioperez.certificate.pdfCertificate.domain.port;


import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;

public interface StudentCertificateMapper {

    StudentCertificate toStudentCertificateDomain(StudentCertificateEvent studentCertificateEvent);
    StudentCertificate toStudentCertificateDomain(StudentCertificateEntity studentCertificateEntity);

    StudentCertificateEntity toStudentCertificateEntity(StudentCertificate studentCertificate);
}
