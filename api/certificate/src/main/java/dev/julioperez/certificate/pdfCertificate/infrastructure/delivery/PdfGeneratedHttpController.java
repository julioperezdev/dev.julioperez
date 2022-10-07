package dev.julioperez.certificate.pdfCertificate.infrastructure.delivery;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pdf")
@AllArgsConstructor
public class PdfGeneratedHttpController {

    //private final PersistStudentDelivery persistStudentDelivery;

    //@GetMapping("/retrieve")
    public void getPdfStudentCourse(){}

    //@GetMapping("/generate")
    public void generatePdf(){}
}
