package workForce.entities;

import workForce.entities.jobs.Job;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JobsInProgress {
    private Map<String, Job> jobs;

    public JobsInProgress() {
        this.jobs = new LinkedHashMap<>();
    }

    public void updateJobsList() {

    }
}
