package dev.julioperez.certificate.shared.infrastructure.configuration;


import dev.julioperez.certificate.pdfCertificate.application.modelMapper.StudentCertificateModelMapper;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter.PersistStudentCertificateAdapterRepository;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery.PersistStudentCertificateDelivery;
import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service.PersistStudentCertificateService;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.dao.StudentCertificateDao;
import dev.julioperez.certificate.shared.application.logger.adapter.LoggerAdapter;
import dev.julioperez.certificate.shared.application.logger.service.LoggerService;
import org.slf4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "dev.julioperez.certificate.*")
@EntityScan(basePackages = "dev.julioperez.certificate.*")
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages = {"dev.julioperez.certificate.*"})
public class SpringDependenciesConfiguration {

    //shared
    Logger logger;
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
    public PersistStudentCertificateAdapterRepository persistStudentCertificateAdapterRepository(){
        return new PersistStudentCertificateAdapterRepository(
                studentCertificateDao,
                studentCertificateModelMapper());
    }

    @Bean
    public PersistStudentCertificateService persistStudentCertificateService(){
        return new PersistStudentCertificateService(persistStudentCertificateAdapterRepository());
    }

    @Bean
    public PersistStudentCertificateDelivery persistStudentCertificateDelivery(){
        return new PersistStudentCertificateDelivery(persistStudentCertificateService(),studentCertificateModelMapper());
    }


    /**
     * =======================shared======================
     */

    /**
     * shared/application/logger
     */

    @Bean
    public LoggerAdapter loggerAdapter(){
        return new LoggerAdapter(logger);
    }
    @Bean
    public LoggerService loggerService(){
        return new LoggerService(loggerAdapter());
    }


    @Value("${julioperezdev.queue.name}")
    public String QUEUE_NAME;

    @Value("${julioperezdev.exchange.name}")
    public String EXCHANGE_NAME;

    @Value("${julioperezdev.routing.key}")
    public String ROUTING_KEY;

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
