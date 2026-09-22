package com.codewithlei.JobTracker.joblisting;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseJobListingDTO {
    private Long id;
    private String companyName;
    private String location;
    private String jobTitle;
    private int minimumSalary;
    private int maximumSalary;
    private int month;
    private int year;
    private InterviewType interviewType;
    private JobStatus stage;
}
