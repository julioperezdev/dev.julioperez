package dev.julioperez.certificate.pdfCertificate.domain.exception;

import dev.julioperez.certificate.shared.domain.exception.DomainError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentCertificateDontHaveValidField extends DomainError {

    public StudentCertificateDontHaveValidField(String message) {
        super(message);
        log.error("StudentCertificate fields can not be null");
    }
}
