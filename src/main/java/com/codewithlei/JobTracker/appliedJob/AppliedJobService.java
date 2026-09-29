package com.codewithlei.JobTracker.appliedJob;

import com.codewithlei.JobTracker.appliedJob.dto.ResponseAppliedJobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppliedJobService {
    private final AppliedJobRepository jobListingRepository;
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
}