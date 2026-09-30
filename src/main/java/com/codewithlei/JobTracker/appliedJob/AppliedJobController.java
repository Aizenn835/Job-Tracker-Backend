package com.codewithlei.JobTracker.appliedJob;

import com.codewithlei.JobTracker.appliedJob.dto.RequestNewApplicationDTO;
import com.codewithlei.JobTracker.appliedJob.dto.ResponseAppliedJobDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @PostMapping
    public ResponseEntity<Map<String, String>> addApplication(@RequestBody @Valid RequestNewApplicationDTO request){
        jobListingService.addApplication(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message" , "Successfully added to your application list."));
    }
}
