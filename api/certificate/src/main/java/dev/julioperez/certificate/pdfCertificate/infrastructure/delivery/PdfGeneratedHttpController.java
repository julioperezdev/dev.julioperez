package dev.julioperez.certificate.pdfCertificate.infrastructure.delivery;

import dev.julioperez.certificate.shared.application.logger.service.LoggerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pdf")
@AllArgsConstructor
@Slf4j
public class PdfGeneratedHttpController {

    //private final PersistStudentDelivery persistStudentDelivery;

    @GetMapping("/retrieve")
    public void getPdfStudentCourse(){
        log.info("executing controller to get pdf by student course");
    }

    //@GetMapping("/generate")
    public void generatePdf(){}
}
