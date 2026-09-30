package com.codewithlei.JobTracker.common.validation;

import com.codewithlei.JobTracker.appliedJob.AppliedJobRepository;
import com.codewithlei.JobTracker.appliedJob.dto.RequestNewApplicationDTO;
import com.codewithlei.JobTracker.appliedJob.exception.ApplicationAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppliedJobValidation {
    private final AppliedJobRepository appliedJobRepository;

    public void validateApplication(RequestNewApplicationDTO request){
        if(appliedJobRepository.existsByCompanyNameAndJobTitle(request.getCompanyName(),
                                                               request.getJobTitle())){
            throw new ApplicationAlreadyExistException();
        }
    }
}
