package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter;


import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
import dev.julioperez.certificate.pdfCertificate.domain.port.PersistStudentCertificateOutputPort;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.dao.StudentCertificateDao;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;

public class PersistStudentCertificateAdapterRepository implements PersistStudentCertificateOutputPort {

    private final StudentCertificateDao studentCertificateDao;
    private final StudentCertificateMapper studentCertificateMapper;

    public PersistStudentCertificateAdapterRepository(StudentCertificateDao studentCertificateDao, StudentCertificateMapper studentCertificateMapper) {
        this.studentCertificateDao = studentCertificateDao;
        this.studentCertificateMapper = studentCertificateMapper;
    }

    @Override
    public void persistStudentCertificate(StudentCertificate studentCertificate) {
        StudentCertificateEntity student = studentCertificateMapper.toStudentCertificateEntity(studentCertificate);
        studentCertificateDao.save(student);
    }
}
