package dev.julioperez.certificate.pdfCertificate.domain.port;

import dev.julioperez.certificate.pdfCertificate.domain.model.GeneratePdfRequest;

public interface GeneratePdfInputPort {
    void generatePdf(GeneratePdfRequest generatePdfRequest);
}
