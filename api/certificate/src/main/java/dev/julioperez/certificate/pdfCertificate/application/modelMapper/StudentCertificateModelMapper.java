package dev.julioperez.certificate.pdfCertificate.application.modelMapper;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;

import java.util.UUID;

public class StudentCertificateModelMapper implements StudentCertificateMapper {

    @Override
    public StudentCertificate toStudentCertificateDomain(StudentCertificateEvent studentCertificateEvent) {
        return new StudentCertificate(
                UUID.randomUUID(),
                studentCertificateEvent.courseId(),
                studentCertificateEvent.courseName(),
                studentCertificateEvent.studentId(),
                studentCertificateEvent.studentName()
        );
    }

    @Override
    public StudentCertificate toStudentCertificateDomain(StudentCertificateEntity studentCertificateEntity) {
        return new StudentCertificate(
                studentCertificateEntity.getId(),
                studentCertificateEntity.getCourseId(),
                studentCertificateEntity.getCourseName(),
                studentCertificateEntity.getStudentId(),
                studentCertificateEntity.getStudentName());
    }

    @Override
    public StudentCertificateEntity toStudentCertificateEntity(dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate studentCertificate) {
        return new StudentCertificateEntity(
                studentCertificate.id(),
                studentCertificate.courseId(),
                studentCertificate.courseName(),
                studentCertificate.studentId(),
                studentCertificate.studentName());
    }
}
