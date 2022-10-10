package dev.julioperez.certificate.pdfCertificate.application.getStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
import dev.julioperez.certificate.pdfCertificate.domain.port.GetStudentCertificateOutputPort;

import java.util.UUID;

public class GetStudentCertificateService implements GetStudentCertificateInterface{

    private final GetStudentCertificateOutputPort getStudentCertificateOutputPort;

    public GetStudentCertificateService(GetStudentCertificateOutputPort getStudentCertificateOutputPort) {
        this.getStudentCertificateOutputPort = getStudentCertificateOutputPort;
    }

    @Override
    public StudentCertificate getStudentCertificateByStudentIdAndCourseId(UUID studentId, UUID courseId) {
        return getStudentCertificateOutputPort.getStudentCertificateByStudentIdAndCourseId(studentId, courseId);
    }
}
