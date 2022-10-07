package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.dao.StudentCertificateDao;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;

public class PersistStudentCertificateRepository {

    private final StudentCertificateDao studentCertificateDao;
    private final StudentCertificateMapper studentCertificateMapper;

    public PersistStudentCertificateRepository(StudentCertificateDao studentCertificateDao, StudentCertificateMapper studentCertificateMapper) {
        this.studentCertificateDao = studentCertificateDao;
        this.studentCertificateMapper = studentCertificateMapper;
    }

    public void saveStudentCertificate(StudentCertificateEvent studentCertificateEvent){
        StudentCertificateEntity student = studentCertificateMapper.toStudentCertificateEntity(studentCertificateEvent);
        studentCertificateDao.save(student);
    }
}
