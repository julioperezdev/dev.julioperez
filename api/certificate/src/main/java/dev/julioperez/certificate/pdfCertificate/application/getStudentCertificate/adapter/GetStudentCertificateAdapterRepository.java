package dev.julioperez.certificate.pdfCertificate.application.getStudentCertificate.adapter;

import dev.julioperez.certificate.pdfCertificate.domain.exception.StudentCertificateDontExist;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
import dev.julioperez.certificate.pdfCertificate.domain.port.GetStudentCertificateOutputPort;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.dao.StudentCertificateDao;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;

import java.util.Optional;
import java.util.UUID;

public class GetStudentCertificateAdapterRepository implements GetStudentCertificateOutputPort {

    private final StudentCertificateDao studentCertificateDao;

    private final StudentCertificateMapper studentCertificateMapper;

    public GetStudentCertificateAdapterRepository(StudentCertificateDao studentCertificateDao, StudentCertificateMapper studentCertificateMapper) {
        this.studentCertificateDao = studentCertificateDao;
        this.studentCertificateMapper = studentCertificateMapper;
    }


    @Override
    public StudentCertificate getStudentCertificateByStudentIdAndCourseId(UUID studentId, UUID courseId) {
        Optional<StudentCertificateEntity> optionalStudentCertificate = studentCertificateDao.findByStudentIdAndCourseId(studentId, courseId);
        StudentCertificateEntity studentCertificateEntity = optionalStudentCertificate.orElseThrow(StudentCertificateDontExist::new);
        return studentCertificateMapper.toStudentCertificateDomain(studentCertificateEntity);
    }
}
