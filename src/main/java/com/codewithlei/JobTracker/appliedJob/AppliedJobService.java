package com.codewithlei.JobTracker.appliedJob;

import com.codewithlei.JobTracker.appliedJob.dto.RequestNewApplicationDTO;
import com.codewithlei.JobTracker.appliedJob.dto.ResponseAppliedJobDTO;
import com.codewithlei.JobTracker.common.validation.AppliedJobValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppliedJobService {
    private final AppliedJobRepository jobListingRepository;
    private final AppliedJobValidation appliedJobValidation;
    private final AppliedJobMapper jobListingMapper;

    public List<ResponseAppliedJobDTO> getAllJobList() {
        return jobListingRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(jobListingMapper::mapToDTO)
                .toList();
    }
    public List<ResponseAppliedJobDTO> searchAppliedJobList(String key){
        return jobListingRepository.findByCompanyNameContainingIgnoreCase(key)
                .stream()
                .map(jobListingMapper::mapToDTO)
                .toList();
    }
    // Remove imgUrl field tomorrow
    @Transactional(rollbackFor = Exception.class)
    public void addApplication(RequestNewApplicationDTO request){
        appliedJobValidation.validateApplication(request);
        AppliedJobEntity applied = jobListingMapper.mapToEntity(request);
        jobListingRepository.save(applied);
    }
}