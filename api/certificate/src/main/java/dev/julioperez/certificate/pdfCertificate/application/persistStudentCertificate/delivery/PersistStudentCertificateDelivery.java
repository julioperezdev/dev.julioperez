package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service.PersistStudentCertificateInterface;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service.PersistStudentCertificateService;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
import dev.julioperez.certificate.pdfCertificate.domain.port.PersistStudentCertificateInputPort;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;

public class PersistStudentCertificateDelivery implements PersistStudentCertificateInputPort {

    private final PersistStudentCertificateInterface persistStudentCertificateService;
    private final StudentCertificateMapper studentCertificateMapper;

    public PersistStudentCertificateDelivery(PersistStudentCertificateInterface persistStudentCertificateService,StudentCertificateMapper studentCertificateMapper) {
        this.persistStudentCertificateService = persistStudentCertificateService;
        this.studentCertificateMapper = studentCertificateMapper;
    }

    @Override
    public void persistStudentCertificate(StudentCertificateEvent studentCertificateEvent) {
        StudentCertificate studentCertificate = studentCertificateMapper.toStudentCertificateDomain(studentCertificateEvent);
        persistStudentCertificateService.persistStudentCertificate(studentCertificate);
    }
}
