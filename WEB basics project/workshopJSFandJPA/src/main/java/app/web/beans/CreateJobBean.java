package app.web.beans;

import app.domain.models.binding.JobBindingModel;
import app.domain.models.service.JobApplicationServiceModel;
import app.services.base.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CreateJobBean extends RedirectBean{

    private JobBindingModel job;
    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    public CreateJobBean() {}

    @Inject
    public CreateJobBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        this.job = new JobBindingModel();
    }

    public void add() {
        this.jobApplicationService.add(this.modelMapper.map(job, JobApplicationServiceModel.class));
        this.redirect("/home");
    }

    public JobBindingModel getJob() {
        return job;
    }

    public void setJob(JobBindingModel job) {
        this.job = job;
    }
}
