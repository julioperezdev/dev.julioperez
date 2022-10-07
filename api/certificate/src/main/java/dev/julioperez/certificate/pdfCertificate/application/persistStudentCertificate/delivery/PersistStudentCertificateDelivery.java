package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.port.PersistStudentCertificatePort;

public class PersistStudentCertificateDelivery {

    private final PersistStudentCertificatePort persistStudentCertificatePort;

    public PersistStudentCertificateDelivery(PersistStudentCertificatePort persistStudentCertificatePort) {
        this.persistStudentCertificatePort = persistStudentCertificatePort;
    }

    public void persistStudentCertificate(StudentCertificateEvent studentCertificateEvent){
        persistStudentCertificatePort.saveStudentCertificate(studentCertificateEvent);
    }
}
