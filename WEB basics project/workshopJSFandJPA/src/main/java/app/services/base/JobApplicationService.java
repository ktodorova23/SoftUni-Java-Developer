package app.services.base;

import app.domain.models.service.JobApplicationServiceModel;

import java.util.List;

public interface JobApplicationService {
    void add(JobApplicationServiceModel jobApplicationServiceModel);

    List<JobApplicationServiceModel> getAll();

    void delete(String id);

    JobApplicationServiceModel findById(String id);
}
