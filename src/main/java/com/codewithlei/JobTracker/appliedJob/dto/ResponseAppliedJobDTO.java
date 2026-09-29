package com.codewithlei.JobTracker.appliedJob.dto;

import com.codewithlei.JobTracker.appliedJob.enums.InterviewType;
import com.codewithlei.JobTracker.appliedJob.enums.JobStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ResponseAppliedJobDTO {
    private Long id;
    private String imgUrl;
    private String companyName;
    private String location;
    private String jobTitle;
    private int minimumSalary;
    private int maximumSalary;
    private LocalDate interviewDate;
    private InterviewType interviewType;
    private JobStatus stage;
}
