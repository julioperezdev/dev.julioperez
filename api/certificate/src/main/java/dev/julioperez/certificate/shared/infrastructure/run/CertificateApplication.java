package dev.julioperez.certificate.shared.infrastructure.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dev"})
public class CertificateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertificateApplication.class, args);
    }

}
