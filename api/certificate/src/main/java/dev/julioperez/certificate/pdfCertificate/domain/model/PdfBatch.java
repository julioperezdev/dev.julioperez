package dev.julioperez.certificate.pdfCertificate.domain.model;

import java.util.UUID;

public record PdfBatch(
        UUID id,
        int attempt) {}
