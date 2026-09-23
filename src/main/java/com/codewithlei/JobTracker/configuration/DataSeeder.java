package com.codewithlei.JobTracker.configuration;

import com.codewithlei.JobTracker.joblisting.enums.InterviewType;
import com.codewithlei.JobTracker.joblisting.JobListing;
import com.codewithlei.JobTracker.joblisting.JobListingRepository;
import com.codewithlei.JobTracker.joblisting.enums.JobStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final JobListingRepository jobListingRepository;

    @Override
    public void run(String... args){
        seedJobs();
    }
    public void seedJobs(){
        if(jobListingRepository.count() > 0){
            return;
        }

        List<JobListing> jobList = List.of(
                JobListing.builder()
                        .companyName("Apple")
                        .location("London, UK")
                        .jobTitle("Central Paradigm Engineer")
                        .minimumSalary(25000)
                        .maximumSalary(65000)
                        .month(5)
                        .year(2025)
                        .interviewType(InterviewType.VIRTUAL)
                        .stage(JobStatus.PENDING)
                        .build(),

                JobListing.builder()
                        .companyName("Google")
                        .location("London, UK")
                        .jobTitle("Dynamic Directives Representative")
                        .minimumSalary(64000)
                        .maximumSalary(90000)
                        .month(1)
                        .year(2025)
                        .interviewType(InterviewType.IN_PERSON)
                        .stage(JobStatus.SHORTLISTED)
                        .build(),

                JobListing.builder()
                        .companyName("Amazon")
                        .location("London, UK")
                        .jobTitle("Future Integration Consultant")
                        .minimumSalary(65000)
                        .maximumSalary(85000)
                        .month(3)
                        .year(2025)
                        .interviewType(InterviewType.HYBRID)
                        .stage(JobStatus.REJECTED)
                        .build() ,

                JobListing.builder()
                        .companyName("Shopify")
                        .location("London, UK")
                        .jobTitle("Chief Interaction Officer")
                        .minimumSalary(50000)
                        .maximumSalary(74000)
                        .month(12)
                        .year(2026)
                        .interviewType(InterviewType.IN_PERSON)
                        .stage(JobStatus.PENDING)
                        .build()
        );

        jobListingRepository.saveAll(jobList);
    }

}
