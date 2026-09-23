package com.codewithlei.JobTracker.joblisting;

import com.codewithlei.JobTracker.joblisting.dto.ResponseJobListingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/job-postings")
@RequiredArgsConstructor
public class JobListingController {
    private final JobListingService jobListingService;

    @GetMapping
    public List<ResponseJobListingDTO> getJobListing(){
        return jobListingService.getAllJobList();
    }
}
