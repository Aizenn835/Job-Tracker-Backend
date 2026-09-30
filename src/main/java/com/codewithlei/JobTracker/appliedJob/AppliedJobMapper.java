package com.codewithlei.JobTracker.appliedJob;

import com.codewithlei.JobTracker.appliedJob.dto.RequestNewApplicationDTO;
import com.codewithlei.JobTracker.appliedJob.dto.ResponseAppliedJobDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
    public AppliedJobEntity mapToEntity(RequestNewApplicationDTO request){
        LocalDateTime now = LocalDateTime.now();
        return AppliedJobEntity.builder()
                .companyName(request.getCompanyName())
                .location(request.getLocation())
                .jobTitle(request.getJobTitle())
                .minimumSalary(request.getMinimumSalary())
                .maximumSalary(request.getMaximumSalary())
                .interviewDate(request.getInterviewDate())
                .interviewType(request.getInterviewType())
                .stage(request.getStage())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
