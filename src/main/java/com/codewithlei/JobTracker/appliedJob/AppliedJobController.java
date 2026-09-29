package com.codewithlei.JobTracker.appliedJob;

import com.codewithlei.JobTracker.appliedJob.dto.ResponseAppliedJobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/applied-job")
@RequiredArgsConstructor
public class AppliedJobController {
    private final AppliedJobService jobListingService;

    @GetMapping
    public List<ResponseAppliedJobDTO> getAppliedJob(){
        return jobListingService.getAllJobList();
    }
    @GetMapping("/search")
    public List<ResponseAppliedJobDTO> searchAppliedJobList(@RequestParam String key){
        return jobListingService.searchAppliedJobList(key);
    }
}
