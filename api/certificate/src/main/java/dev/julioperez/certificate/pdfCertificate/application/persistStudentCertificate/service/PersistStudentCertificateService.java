package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.domain.exception.StudentCertificateDontHaveValidField;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
import dev.julioperez.certificate.pdfCertificate.domain.port.PersistStudentCertificateOutputPort;

public class PersistStudentCertificateService implements PersistStudentCertificateInterface{

    private final PersistStudentCertificateOutputPort persistStudentCertificateOutputPort;

    public PersistStudentCertificateService(PersistStudentCertificateOutputPort persistStudentCertificateOutputPort) {
        this.persistStudentCertificateOutputPort = persistStudentCertificateOutputPort;
    }

    public void persistStudentCertificate(StudentCertificate studentCertificate) {
        validateStudentCertificateEventFields(studentCertificate);
        persistStudentCertificateOutputPort.persistStudentCertificate(studentCertificate);
    }

    private void validateStudentCertificateEventFields(StudentCertificate studentCertificate){
        if(studentCertificate.isInvalidFields()){
            throw new StudentCertificateDontHaveValidField("error in saveStudentCertificate because studentCertificateEvent has invalid fields");
        }
    }
}
