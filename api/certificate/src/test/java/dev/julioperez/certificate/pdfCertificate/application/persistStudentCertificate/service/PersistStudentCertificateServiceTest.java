package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter.PersistStudentCertificateAdapterRepository;
import dev.julioperez.certificate.pdfCertificate.domain.exception.StudentCertificateDontHaveValidField;
import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificate;
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

        StudentCertificate studentCertificate = mock(StudentCertificate.class);

        @Test
        void itShouldSaveStudentCertificateWithoutCertificateHashHappyCase(){
            //given
            //when
            service.persistStudentCertificate(studentCertificate);
            //then
            then(persistStudentCertificateRepository).should().persistStudentCertificate(studentCertificate);
            then(persistStudentCertificateRepository).shouldHaveNoMoreInteractions();
        }

        @Test
        void itShouldNotSaveStudentCertificateWithSomeNullFieldNotHappyCase(){
            //given
            //when
            when(studentCertificate.isInvalidFields()).thenReturn(Boolean.TRUE);
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.persistStudentCertificate(studentCertificate));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }

     }
}