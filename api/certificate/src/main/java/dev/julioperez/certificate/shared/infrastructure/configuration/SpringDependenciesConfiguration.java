package dev.julioperez.certificate.shared.infrastructure.configuration;


import dev.julioperez.certificate.pdfCertificate.application.modelMapper.StudentCertificateModelMapper;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter.PersistStudentCertificateRepository;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.PersistStudentCertificateDelivery;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service.PersistStudentCertificateService;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.dao.StudentCertificateDao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "dev.julioperez.certificate.*")
@EntityScan(basePackages = "dev.julioperez.certificate.*")
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.certificate.*"})
public class SpringDependenciesConfiguration {

    //pdfCertificate
    private final StudentCertificateDao studentCertificateDao;

    public SpringDependenciesConfiguration(StudentCertificateDao studentCertificateDao) {
        this.studentCertificateDao = studentCertificateDao;
    }

    /**
     * =======================pdfCertificate======================
     */

    /**
     * pdfCertificate/application/modelMapper
     */

    @Bean
    public StudentCertificateModelMapper studentCertificateModelMapper(){
        return new StudentCertificateModelMapper();
    }

    /**
     * pdfCertificate/application/persistStudentCertificate
     */

    @Bean
    public PersistStudentCertificateRepository persistStudentCertificateRepository(){
        return new PersistStudentCertificateRepository(
                studentCertificateDao,
                studentCertificateModelMapper());
    }

    @Bean
    public PersistStudentCertificateService persistStudentCertificateService(){
        return new PersistStudentCertificateService(
                studentCertificateModelMapper());
    }

    @Bean
    public PersistStudentCertificateDelivery persistStudentCertificateDelivery(){
        return new PersistStudentCertificateDelivery(persistStudentCertificateService());
    }

}
