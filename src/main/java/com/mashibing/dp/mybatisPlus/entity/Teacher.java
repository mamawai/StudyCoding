package com.mashibing.dp.mybatisPlus.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "teacher_info")
public class Teacher {
    @Id
    @Column(name = "id")
    private Integer userId;
    @Column(name = "teachername")
    private String teacherName;
    @Column(name = "teacherid")
    private Integer teacherId;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phoneNumber;
    @Column(name = "subject")
    private String subject;
}
