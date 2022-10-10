package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.delivery;

import dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.service.PersistStudentCertificateInterface;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class PersistStudentCertificateDeliveryTest {

    @Mock
    StudentCertificateMapper studentCertificateMapper;

    @Mock
    PersistStudentCertificateInterface persistStudentCertificateService;

    @InjectMocks
    PersistStudentCertificateDelivery delivery;

    @Test
    void itShouldConvertWithModelMapperAndSendToServiceHappyCase(){
        //given
        StudentCertificateEvent studentCertificateEventMock = mock(StudentCertificateEvent.class);
        //when
        delivery.persistStudentCertificate(studentCertificateEventMock);
        //then
        then(studentCertificateMapper).should().toStudentCertificateDomain(studentCertificateEventMock);
        then(studentCertificateMapper).shouldHaveNoMoreInteractions();
        then(persistStudentCertificateService).should().persistStudentCertificate(studentCertificateMapper.toStudentCertificateDomain(studentCertificateEventMock));
        then(persistStudentCertificateService).shouldHaveNoMoreInteractions();
    }
}