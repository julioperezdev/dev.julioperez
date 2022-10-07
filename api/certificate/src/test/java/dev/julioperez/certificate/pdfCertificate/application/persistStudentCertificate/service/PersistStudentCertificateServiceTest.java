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

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class PersistStudentCertificateServiceTest {

    @Mock
    PersistStudentCertificateAdapterRepository persistStudentCertificateRepository;

    @InjectMocks
    PersistStudentCertificateService service;

    @Nested
    public class saveStudentCertificateService{

        @Test
        void itShouldSaveStudentCertificateWithoutCertificateHashHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithValidFields =
             new StudentCertificateEvent(
                     UUID.randomUUID(),
                     "Java Course",
                     UUID.randomUUID(),
                     "Joe Smith");
            //when
            service.saveStudentCertificate(studentCertificateEventWithValidFields);
            //then
            then(persistStudentCertificateRepository).should().saveStudentCertificate(any(StudentCertificateEvent.class));
        }

        @Test
        void itShouldNotSaveStudentCertificateWithoutCourseIdNullNotHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithCourseIdNull =
                    new StudentCertificateEvent(
                            null,
                            "Java Course",
                            UUID.randomUUID(),
                            "Joe Smith");
            //when
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.saveStudentCertificate(studentCertificateEventWithCourseIdNull));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }

        @Test
        void itShouldNotSaveStudentCertificateWithoutCourseNameNullNotHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithCourseNameNull =
                    new StudentCertificateEvent(
                            UUID.randomUUID(),
                            null,
                            UUID.randomUUID(),
                            "Joe Smith");
            //when
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.saveStudentCertificate(studentCertificateEventWithCourseNameNull));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }

        @Test
        void itShouldNotSaveStudentCertificateWithoutStudentIdNullNotHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithStudentIdNull =
                    new StudentCertificateEvent(
                            UUID.randomUUID(),
                            "Java Course",
                            null,
                            "Joe Smith");
            //when
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.saveStudentCertificate(studentCertificateEventWithStudentIdNull));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }

        @Test
        void itShouldNotSaveStudentCertificateWithoutStudentNameNullNotHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithStudentNameNull =
                    new StudentCertificateEvent(
                            UUID.randomUUID(),
                            "Java Course",
                            UUID.randomUUID(),
                            null);
            //when
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.saveStudentCertificate(studentCertificateEventWithStudentNameNull));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }

        @Test
        void itShouldNotSaveStudentCertificateWithoutNullFieldsNotHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithoutNullFields =
                    new StudentCertificateEvent(
                            null,
                            null,
                            null,
                            null);
            //when
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.saveStudentCertificate(studentCertificateEventWithoutNullFields));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }

        @Test
        void itShouldNotSaveStudentCertificateWithoutRandomNullFieldsNotHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithoutRandomNullFields =
                    new StudentCertificateEvent(
                            UUID.randomUUID(),
                            null,
                            UUID.randomUUID(),
                            null);
            //when
            //then
            assertThrows(StudentCertificateDontHaveValidField.class, () -> service.saveStudentCertificate(studentCertificateEventWithoutRandomNullFields));
            then(persistStudentCertificateRepository).shouldHaveNoInteractions();
        }
     }
}