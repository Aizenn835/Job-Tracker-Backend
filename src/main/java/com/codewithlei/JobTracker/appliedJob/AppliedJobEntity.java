package com.codewithlei.JobTracker.appliedJob;

import com.codewithlei.JobTracker.appliedJob.enums.InterviewType;
import com.codewithlei.JobTracker.appliedJob.enums.JobStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "applied_job")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppliedJobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recruiter_pfp")
    private String imgUrl;

    @Column(name = "company_name" , nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String location;

    @Column(name = "job_title" , nullable = false)
    private String jobTitle;

    @Column(name = "minimum_salary" , nullable = false)
    private int minimumSalary;

    @Column(name = "maximum_salary" , nullable = false)
    private int maximumSalary;

    @Column( name = "interview_date" , nullable = false)
    private LocalDate interviewDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "interview_type")
    private InterviewType interviewType;

    @Enumerated(EnumType.STRING)
    private JobStatus stage;

    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
}
