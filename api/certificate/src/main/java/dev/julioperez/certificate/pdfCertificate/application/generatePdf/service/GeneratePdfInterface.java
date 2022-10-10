package dev.julioperez.certificate.pdfCertificate.application.generatePdf.service;

import dev.julioperez.certificate.pdfCertificate.domain.model.GeneratePdfRequest;

public interface GeneratePdfInterface {
    void generatePdf(GeneratePdfRequest generatePdfRequest);
}
