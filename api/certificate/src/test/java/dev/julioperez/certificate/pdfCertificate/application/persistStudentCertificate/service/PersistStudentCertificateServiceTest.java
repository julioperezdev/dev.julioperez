package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.application.modelMapper.StudentCertificateModelMapper;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model.StudentCertificateEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class PersistStudentCertificateServiceTest {

    @Mock
    StudentCertificateModelMapper studentCertificateModelMapper;

    @InjectMocks
    PersistStudentCertificateService service;

    @Nested
    public class saveStudentCertificate{

        StudentCertificateEvent studentCertificateEvent =
                new StudentCertificateEvent(
                        UUID.randomUUID(),
                        "Java Course",
                        UUID.randomUUID(),
                        "Joe Smith");

         @Test
         void itShouldSaveStudentCertificateWithoutCertificateHashHappyCase(){
             //given
             given(studentCertificateModelMapper
                     .toStudentCertificateEntity(studentCertificateEvent))
                     .willReturn(any(StudentCertificateEntity.class));
             //when
             service.saveStudentCertificate(studentCertificateEvent);
             //then
             then(studentCertificateModelMapper)
                     .should()
                     .toStudentCertificateEntity(any(StudentCertificateEvent.class));
             then(studentCertificateModelMapper).shouldHaveNoMoreInteractions();
         }
     }
}