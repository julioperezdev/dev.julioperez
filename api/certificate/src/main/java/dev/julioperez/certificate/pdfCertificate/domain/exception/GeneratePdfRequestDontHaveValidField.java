package dev.julioperez.certificate.pdfCertificate.domain.exception;

import dev.julioperez.certificate.shared.domain.exception.DomainError;

public class GeneratePdfRequestDontHaveValidField extends DomainError {
    public GeneratePdfRequestDontHaveValidField() {
        super("Error because GeneratePdfRequest dont have valid fields");
    }
}
