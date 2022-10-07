package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter.PersistStudentCertificateAdapterRepository;
import dev.julioperez.certificate.pdfCertificate.domain.exception.StudentCertificateDontHaveValidField;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.port.PersistStudentCertificatePort;

public class PersistStudentCertificateService implements PersistStudentCertificatePort {
    private final PersistStudentCertificateAdapterRepository persistStudentCertificateRepository;

    public PersistStudentCertificateService(PersistStudentCertificateAdapterRepository persistStudentCertificateRepository) {
        this.persistStudentCertificateRepository = persistStudentCertificateRepository;
    }

    @Override
    public void saveStudentCertificate(StudentCertificateEvent studentCertificateEvent) {
        validateStudentCertificateEventFields(studentCertificateEvent);
        persistStudentCertificateRepository.saveStudentCertificate(studentCertificateEvent);
    }

    private void validateStudentCertificateEventFields(StudentCertificateEvent studentCertificateEvent){
        if(studentCertificateEvent.isInvalidFields()){
            throw new StudentCertificateDontHaveValidField("error in saveStudentCertificate because studentCertificateEvent has invalid fields");
        }
    }
}
