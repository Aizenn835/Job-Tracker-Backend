package com.codewithlei.JobTracker.appliedJob.dto;

import com.codewithlei.JobTracker.appliedJob.enums.InterviewType;
import com.codewithlei.JobTracker.appliedJob.enums.JobStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestNewApplicationDTO {


    @NotBlank(message = "Must include a company name")
    @Size(min = 1, max = 50, message = "Company name must be between 1 and 50 characters")
    private String companyName;

    @Size(max = 50, message = "location cannot exceed 50 characters")
    private String location;

    @NotBlank(message = "Must include a Job Title")
    @Size(max = 50, message = "Job Title cannot exceed 50 characters")
    private String jobTitle;

    @Min(value = 0, message = "Minimum salary cannot be negative")
    private int minimumSalary;

    @Min(value = 0, message = "Maximum salary cannot be negative")
    private int maximumSalary;

    @NotNull(message = "Interview date is required")
    @FutureOrPresent(message = "Interview date must be today or in the future")
    private LocalDate interviewDate;

    @NotNull(message = "Interview type is required")
    private InterviewType interviewType;

    @NotNull(message = "Job status stage is required")
    private JobStatus stage;

}
