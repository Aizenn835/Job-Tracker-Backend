package com.codewithlei.JobTracker.appliedJob;

import com.codewithlei.JobTracker.appliedJob.dto.ResponseAppliedJobDTO;
import org.springframework.stereotype.Component;

@Component
public class AppliedJobMapper {
    public ResponseAppliedJobDTO mapToDTO(AppliedJobEntity job){
       return ResponseAppliedJobDTO.builder()
                .id(job.getId())
                .imgUrl(job.getImgUrl())
                .companyName(job.getCompanyName())
                .location(job.getLocation())
                .jobTitle(job.getJobTitle())
                .minimumSalary(job.getMinimumSalary())
                .maximumSalary(job.getMaximumSalary())
                .interviewDate(job.getInterviewDate())
                .interviewType(job.getInterviewType())
                .stage(job.getStage())
                .build();
    }
}
