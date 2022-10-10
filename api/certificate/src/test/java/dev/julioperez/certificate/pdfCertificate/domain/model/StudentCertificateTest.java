package dev.julioperez.certificate.pdfCertificate.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentCertificateTest {

    @Test
    void itShouldValidIfEachFieldsHaveValuesHappyCase(){
        //given
        StudentCertificate studentCertificateHappyCase =
                new StudentCertificate(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        "Java Course",
                        UUID.randomUUID(),
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateHappyCase.isInvalidFields();
        //then
        assertFalse(isInvalidFields);
    }

    @Test
    void itShouldValidThatCourseIdIsNullNotHappyCase(){
        //given
        StudentCertificate studentCertificateWithCourseIdNull =
                new StudentCertificate(
                        UUID.randomUUID(),
                        null,
                        "Java Course",
                        UUID.randomUUID(),
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateWithCourseIdNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatCourseNameIsNullNotHappyCase(){
        //given
        StudentCertificate studentCertificateWithCourseNameNull =
                new StudentCertificate(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        null,
                        UUID.randomUUID(),
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateWithCourseNameNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatStudentIdIsNullNotHappyCase(){
        //given
        StudentCertificate studentCertificateWithStudentIdNull =
                new StudentCertificate(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        "Java Course",
                        null,
                        "Joe Smith");
        //when
        boolean isInvalidFields = studentCertificateWithStudentIdNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatStudentNameIsNullNotHappyCase(){
        //given
        StudentCertificate studentCertificateWithStudentNameNull =
                new StudentCertificate(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        "Java Course",
                        UUID.randomUUID(),
                        null);
        //when
        boolean isInvalidFields = studentCertificateWithStudentNameNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

    @Test
    void itShouldValidThatCourseNameAndStudentNameAreNullNotHappyCase(){
        //given
        StudentCertificate studentCertificateWithCourseNameAndStudentNameIsNull =
                new StudentCertificate(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        null,
                        UUID.randomUUID(),
                        null);
        //when
        boolean isInvalidFields = studentCertificateWithCourseNameAndStudentNameIsNull.isInvalidFields();
        //then
        assertTrue(isInvalidFields);
    }

}