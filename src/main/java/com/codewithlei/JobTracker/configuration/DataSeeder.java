package com.codewithlei.JobTracker.configuration;

import com.codewithlei.JobTracker.appliedJob.AppliedJobEntity;
import com.codewithlei.JobTracker.appliedJob.AppliedJobRepository;
import com.codewithlei.JobTracker.appliedJob.enums.InterviewType;
import com.codewithlei.JobTracker.appliedJob.enums.JobStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private static final String IMAGE_PATH = "/uploads/profile-image/";

    private final AppliedJobRepository jobListingRepository;

    @Override
    public void run(String... args) {
        seedJobs();
    }

    public void seedJobs() {
        if (jobListingRepository.count() > 0) {
            return;
        }

        List<AppliedJobEntity> jobList = List.of(
                createJob("arcticwolf.svg", "Arctic Wolf", "Minneapolis, USA", "Security Operations Engineer",
                        70000, 95000, LocalDate.of(2026, 10, 14), InterviewType.VIRTUAL, JobStatus.PENDING),
                createJob("gamma-promotion.svg", "Gamma Promotion", "Manchester, UK", "Junior Java Developer",
                        32000, 45000, LocalDate.of(2026, 11, 5), InterviewType.HYBRID, JobStatus.SHORTLISTED),
                createJob("intagram.svg", "Instagram", "Dublin, Ireland", "Backend Software Engineer",
                        75000, 110000, LocalDate.of(2026, 12, 2), InterviewType.VIRTUAL, JobStatus.PENDING),
                createJob("kazanskaya-yarmarka.svg", "Kazanskaya Yarmarka", "Kazan, Russia", "API Integration Developer",
                        28000, 40000, LocalDate.of(2026, 9, 21), InterviewType.IN_PERSON, JobStatus.REJECTED),
                createJob("linkedin-icon-2.svg", "LinkedIn", "London, UK", "Associate Software Engineer",
                        60000, 85000, LocalDate.of(2027, 1, 12), InterviewType.HYBRID, JobStatus.SHORTLISTED),
                createJob("microsoft.svg", "Microsoft", "Reading, UK", "Cloud Backend Developer",
                        65000, 95000, LocalDate.of(2026, 11, 18), InterviewType.VIRTUAL, JobStatus.PENDING),
                createJob("microsoft-teams.svg", "Microsoft Teams", "Dublin, Ireland", "Platform Services Engineer",
                        62000, 90000, LocalDate.of(2026, 8, 27), InterviewType.IN_PERSON, JobStatus.REJECTED),
                createJob("puma-logo.svg", "Puma", "Herzogenaurach, Germany", "E-commerce Backend Developer",
                        48000, 68000, LocalDate.of(2026, 12, 9), InterviewType.HYBRID, JobStatus.SHORTLISTED),
                createJob("samsung.svg", "Samsung", "Seoul, South Korea", "Java Application Developer",
                        55000, 80000, LocalDate.of(2027, 2, 3), InterviewType.IN_PERSON, JobStatus.PENDING)
        );

        jobListingRepository.saveAll(jobList);
    }

    private AppliedJobEntity createJob(String fileName, String companyName, String location, String jobTitle,
                                       int minimumSalary, int maximumSalary, LocalDate interviewDate,
                                       InterviewType interviewType, JobStatus stage) {
        return AppliedJobEntity.builder()
                .imgUrl(IMAGE_PATH + fileName)
                .companyName(companyName)
                .location(location)
                .jobTitle(jobTitle)
                .minimumSalary(minimumSalary)
                .maximumSalary(maximumSalary)
                .interviewDate(interviewDate)
                .interviewType(interviewType)
                .stage(stage)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}