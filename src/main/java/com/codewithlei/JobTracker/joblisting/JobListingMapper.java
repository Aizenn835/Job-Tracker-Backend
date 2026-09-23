package com.codewithlei.JobTracker.joblisting;

import com.codewithlei.JobTracker.joblisting.dto.ResponseJobListingDTO;
import org.springframework.stereotype.Component;

@Component
public class JobListingMapper {
    public ResponseJobListingDTO mapToDTO(JobListing job){
       return ResponseJobListingDTO.builder()
                .id(job.getId())
                .companyName(job.getCompanyName())
                .location(job.getLocation())
                .jobTitle(job.getJobTitle())
                .minimumSalary(job.getMinimumSalary())
                .maximumSalary(job.getMaximumSalary())
                .month(job.getMonth())
                .year(job.getYear())
                .interviewType(job.getInterviewType())
                .stage(job.getStage())
                .build();
    }
}
