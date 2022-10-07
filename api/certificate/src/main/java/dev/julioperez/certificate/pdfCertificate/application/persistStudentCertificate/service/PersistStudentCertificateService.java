package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.application.modelMapper.StudentCertificateModelMapper;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.port.PersistStudentCertificatePort;

public class PersistStudentCertificateService implements PersistStudentCertificatePort {

    private final StudentCertificateModelMapper studentCertificateModelMapper;

    public PersistStudentCertificateService(StudentCertificateModelMapper studentCertificateModelMapper) {
        this.studentCertificateModelMapper = studentCertificateModelMapper;
    }

    @Override
    public void saveStudentCertificate(StudentCertificateEvent studentCertificateEvent) {
        studentCertificateModelMapper.toStudentCertificateEntity(studentCertificateEvent);
    }
}
