package dev.julioperez.certificate.pdfCertificate.infrastructure.repository.dao;

import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface StudentCertificateDao extends JpaRepository<StudentCertificateEntity, UUID> {
}
