package dev.julioperez.certificate.pdfCertificate.application.generatePdf.delivery;

import dev.julioperez.certificate.pdfCertificate.application.generatePdf.service.GeneratePdfInterface;
import dev.julioperez.certificate.pdfCertificate.domain.model.GeneratePdfRequest;
import dev.julioperez.certificate.pdfCertificate.domain.port.GeneratePdfInputPort;

public class GeneratePdfDelivery implements GeneratePdfInputPort {

    private final GeneratePdfInterface generatePdfService;

    public GeneratePdfDelivery(GeneratePdfInterface generatePdfService) {
        this.generatePdfService = generatePdfService;
    }

    @Override
    public void generatePdf(GeneratePdfRequest generatePdfRequest) {
        generatePdfService.generatePdf(generatePdfRequest);
    }
}
