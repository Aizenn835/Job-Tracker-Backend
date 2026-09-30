package com.codewithlei.JobTracker.appliedJob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliedJobRepository extends JpaRepository<AppliedJobEntity, Long> {
    List<AppliedJobEntity> findAllByOrderByCreatedAtDesc();
    List<AppliedJobEntity> findByCompanyNameContainingIgnoreCase(String companyName);
    Boolean existsByCompanyNameAndJobTitle(String companyName, String jobTitle);
}
