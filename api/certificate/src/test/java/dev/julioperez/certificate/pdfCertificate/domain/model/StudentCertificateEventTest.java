package dev.julioperez.certificate.pdfCertificate.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentCertificateEventTest {

    @Test
    void itShouldValidIfEachFieldsHaveValuesHappyCase(){
        //given
        StudentCertificateEvent studentCertificateEventHappyCase =
                new StudentCertificateEvent(
                        UUID.randomUUID(),
                        "Java Course",
                        UUID.randomUUID(),
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateEventHappyCase.isInvalidFields();
        //then
        assertFalse(isInvalidFields);
    }

    @Test
    void itShouldValidThatCourseIdIsNullNotHappyCase(){
        //given
        StudentCertificateEvent studentCertificateEventWithCourseIdNull =
                new StudentCertificateEvent(
                        null,
                        "Java Course",
                        UUID.randomUUID(),
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateEventWithCourseIdNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatCourseNameIsNullNotHappyCase(){
        //given
        StudentCertificateEvent studentCertificateEventWithCourseNameNull =
                new StudentCertificateEvent(
                        UUID.randomUUID(),
                        null,
                        UUID.randomUUID(),
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateEventWithCourseNameNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatStudentIdIsNullNotHappyCase(){
        //given
        StudentCertificateEvent studentCertificateEventWithStudentIdNull =
                new StudentCertificateEvent(
                        UUID.randomUUID(),
                        "Java Course",
                        null,
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateEventWithStudentIdNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatStudentNameIsNullNotHappyCase(){
        //given
        StudentCertificateEvent studentCertificateEventWithStudentNameNull =
                new StudentCertificateEvent(
                        UUID.randomUUID(),
                        "Java Course",
                        UUID.randomUUID(),
                        null);
        //when
        boolean isInvalidFields = studentCertificateEventWithStudentNameNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatCourseNameAndStudentNameAreNullNotHappyCase(){
        //given
        StudentCertificateEvent studentCertificateEventWithCourseNameAndStudentNameIsNull =
                new StudentCertificateEvent(
                        UUID.randomUUID(),
                        null,
                        UUID.randomUUID(),
                        null);
        //when
        boolean isInvalidFields = studentCertificateEventWithCourseNameAndStudentNameIsNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

}