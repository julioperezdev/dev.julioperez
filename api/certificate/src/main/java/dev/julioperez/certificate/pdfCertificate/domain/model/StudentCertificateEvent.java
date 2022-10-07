package dev.julioperez.certificate.pdfCertificate.domain.model;

import java.util.Objects;
import java.util.UUID;
public record StudentCertificateEvent(
        UUID courseId,
        String courseName,
        UUID studentId,
        String studentName
) {
    public boolean isInvalidFields(){
        return Objects.isNull(courseId()) ||
                Objects.isNull(courseName()) ||
                Objects.isNull(studentId()) ||
                Objects.isNull(studentName());
    }
}

