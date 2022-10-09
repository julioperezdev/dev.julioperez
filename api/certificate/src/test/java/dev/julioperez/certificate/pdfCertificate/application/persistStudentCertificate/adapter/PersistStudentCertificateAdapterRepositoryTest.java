package dev.julioperez.certificate.pdfCertificate.application.persistStudentCertificate.adapter;

import dev.julioperez.certificate.pdfCertificate.domain.model.StudentCertificateEvent;
import dev.julioperez.certificate.pdfCertificate.domain.port.StudentCertificateMapper;
import dev.julioperez.certificate.pdfCertificate.infrastructure.repository.dao.StudentCertificateDao;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class PersistStudentCertificateAdapterRepositoryTest {

    @Mock
    StudentCertificateDao studentCertificateDao;

    @Mock
    StudentCertificateMapper studentCertificateMapper;

    @InjectMocks
    PersistStudentCertificateAdapterRepository adapter;

    @Nested
    public class saveStudentCertificateAdapter{

        @Test
        void itShouldSaveStudentCertificateWithoutCertificateHashHappyCase(){
            //given
            StudentCertificateEvent studentCertificateEventWithValidFields = mock(StudentCertificateEvent.class);
            //when
            adapter.saveStudentCertificate(studentCertificateEventWithValidFields);

            //then
            then(studentCertificateMapper).should().toStudentCertificateEntity(studentCertificateEventWithValidFields);
            then(studentCertificateMapper).shouldHaveNoMoreInteractions();
            then(studentCertificateDao).should().save(studentCertificateMapper.toStudentCertificateEntity(studentCertificateEventWithValidFields));
            then(studentCertificateDao).shouldHaveNoMoreInteractions();
        }
    }
}