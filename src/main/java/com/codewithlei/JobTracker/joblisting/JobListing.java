package com.codewithlei.JobTracker.joblisting;

import com.codewithlei.JobTracker.joblisting.enums.InterviewType;
import com.codewithlei.JobTracker.joblisting.enums.JobStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(nullable = false)
    private int month;

    @Column(nullable = false)
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(name = "interview_type")
    private InterviewType interviewType;

    @Enumerated(EnumType.STRING)
    private JobStatus stage;
}
