package dev.julioperez.certificate.pdfCertificate.domain.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentCertificateDontHaveValidField extends RuntimeException{

    public StudentCertificateDontHaveValidField(String message) {
        super(message);
        log.error("StudentCertificate fields can not be null");
    }
}
