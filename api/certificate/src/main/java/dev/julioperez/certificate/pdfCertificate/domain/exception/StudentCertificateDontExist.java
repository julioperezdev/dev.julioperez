package dev.julioperez.certificate.pdfCertificate.domain.exception;

import dev.julioperez.certificate.shared.domain.exception.DomainError;

public class StudentCertificateDontExist extends DomainError {

    public StudentCertificateDontExist() {
        super("Student certificate dont exist");
    }
}
