package app.web.beans;

import app.domain.models.view.JobViewModel;
import app.services.base.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobDetailsBean {

    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    public JobDetailsBean() {}

    @Inject
    public JobDetailsBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    public JobViewModel jobViewModel(String id) {
        return this.modelMapper.map(this.jobApplicationService.findById(id), JobViewModel.class);
    }

}
