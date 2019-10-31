package app.repositories.base;

import app.domain.entities.JobApplication;

import java.util.List;

public interface JobApplicationRepository {
    void save(JobApplication job);

    List<JobApplication> findAll();

    void deleteById(String id);

    JobApplication findById(String id);
}
