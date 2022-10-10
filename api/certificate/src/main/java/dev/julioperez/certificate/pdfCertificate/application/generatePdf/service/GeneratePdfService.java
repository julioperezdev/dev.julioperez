package dev.julioperez.certificate.pdfCertificate.application.generatePdf.service;

import dev.julioperez.certificate.pdfCertificate.application.getStudentCertificate.service.GetStudentCertificateInterface;
import dev.julioperez.certificate.pdfCertificate.domain.exception.GeneratePdfRequestDontHaveValidField;
import dev.julioperez.certificate.pdfCertificate.domain.model.GeneratePdfRequest;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;

public class GeneratePdfService implements GeneratePdfInterface{

    private final GetStudentCertificateInterface getStudentCertificate;

    public GeneratePdfService(GetStudentCertificateInterface getStudentCertificate) {
        this.getStudentCertificate = getStudentCertificate;
    }

    @Override
    public void generatePdf(GeneratePdfRequest generatePdfRequest) {
        validateGeneratePdfRequestFields(generatePdfRequest);
        StudentCertificate studentCertificate = getStudentCertificate.getStudentCertificateByStudentIdAndCourseId(
                generatePdfRequest.studentId(),
                generatePdfRequest.courseId());
    }

    private void validateGeneratePdfRequestFields(GeneratePdfRequest generatePdfRequest){
        if(generatePdfRequest.isInvalidFields()) throw new GeneratePdfRequestDontHaveValidField();
    }
}
