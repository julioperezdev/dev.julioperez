package dev.julioperez.certificate.pdfCertificate.domain.port;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;

import java.util.UUID;

public interface GetStudentCertificateOutputPort {

    StudentCertificate getStudentCertificateByStudentIdAndCourseId(UUID studentId, UUID courseId);
}
