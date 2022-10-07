package dev.julioperez.certificate.pdfCertificate.application.modelMapper;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;

import java.util.UUID;

public class StudentCertificateModelMapper implements StudentCertificateMapper {

    @Override
    public StudentCertificateEntity toStudentCertificateEntity(StudentCertificateEvent studentCertificateEvent) {
        return new StudentCertificateEntity(
                UUID.randomUUID(),
                studentCertificateEvent.courseId(),
                studentCertificateEvent.courseName(),
                studentCertificateEvent.studentId(),
                studentCertificateEvent.studentName());
    }
}
