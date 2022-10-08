package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter.PersistStudentCertificateAdapterRepository;
import dev.julioperez.certificate.pdfCertificate.domain.exception.StudentCertificateDontHaveValidField;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class PersistStudentCertificateServiceTest {

    @Mock
    PersistStudentCertificateAdapterRepository persistStudentCertificateRepository;

    @InjectMocks
    PersistStudentCertificateService service;

    @Nested
    public class saveStudentCertificateService{

        StudentCertificateEvent studentCertificateEvent = mock(StudentCertificateEvent.class);

        @Test
        void itShouldSaveStudentCertificateWithoutCertificateHashHappyCase(){
            //given
            //when
            service.saveStudentCertificate(studentCertificateEvent);
            //then
            then(persistStudentCertificateRepository).should().saveStudentCertificate(studentCertificateEvent);
            then(persistStudentCertificateRepository).shouldHaveNoMoreInteractions();
        }

        @Test
        void itShouldNotSaveStudentCertificateWithSomeNullFieldNotHappyCase(){
            //given
            //when
            when(studentCertificateEvent.isInvalidFields()).thenReturn(Boolean.TRUE);
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.saveStudentCertificate(studentCertificateEvent));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }

     }
}