package com.codewithlei.JobTracker.joblisting;

import com.codewithlei.JobTracker.joblisting.dto.ResponseJobListingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobListingService {
    private final JobListingRepository jobListingRepository;
    private final JobListingMapper jobListingMapper;

    public List<ResponseJobListingDTO> getAllJobList(){
        return jobListingRepository.findAll()
                .stream()
                .map(jobListingMapper::mapToDTO)
                .toList();
    }
}
