package dev.julioperez.certificate.pdfCertificate.infrastructure.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "STUDENT")
public class StudentCertificateEntity {

    @Id
    private UUID id;

    @Column(name = "course_id", nullable = false)
    private UUID courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "certificate_hash")
    private String certificateHash;

    public StudentCertificateEntity(UUID id, UUID courseId, String courseName, UUID studentId, String studentName) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentId = studentId;
        this.studentName = studentName;
    }
}
