package app.services;

import app.domain.entities.JobApplication;
import app.domain.entities.Sector;
import app.domain.models.service.JobApplicationServiceModel;
import app.repositories.base.JobApplicationRepository;
import app.services.base.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobApplicationServiceImpl implements JobApplicationService {

    private JobApplicationRepository jobApplicationRepository;
    private ModelMapper modelMapper;

    @Inject
    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository, ModelMapper modelMapper) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(JobApplicationServiceModel jobApplicationServiceModel) {
        JobApplication job = this.modelMapper.map(jobApplicationServiceModel, JobApplication.class);
        job.setSector(Sector.valueOf(jobApplicationServiceModel.getSector()));
        this.jobApplicationRepository.save(job);
    }

    @Override
    public List<JobApplicationServiceModel> getAll() {
        return this.jobApplicationRepository.findAll().stream()
                .map(j -> this.modelMapper.map(j, JobApplicationServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.jobApplicationRepository.deleteById(id);
    }

    @Override
    public JobApplicationServiceModel findById(String id) {
        return this.modelMapper.map(this.jobApplicationRepository.findById(id), JobApplicationServiceModel.class);
    }
}
