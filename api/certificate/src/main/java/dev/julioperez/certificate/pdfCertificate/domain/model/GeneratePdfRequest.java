package dev.julioperez.certificate.pdfCertificate.domain.model;

import java.util.Objects;
import java.util.UUID;

public record GeneratePdfRequest(
        UUID studentId,
        UUID courseId
) {
    public boolean isInvalidFields(){
        return Objects.isNull(courseId()) ||
                Objects.isNull(studentId());
    }
}
