package dev.julioperez.certificate.pdfCertificate.application.getStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;

import java.util.UUID;

public interface GetStudentCertificateInterface {

    StudentCertificate getStudentCertificateByStudentIdAndCourseId(UUID studentId, UUID courseId);
}
