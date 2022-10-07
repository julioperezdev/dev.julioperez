package dev.julioperez.certificate.pdfCertificate.domain.model;

import java.util.UUID;
public record StudentCertificateEvent(
        UUID courseId,
        String courseName,
        UUID studentId,
        String studentName
) {
}

