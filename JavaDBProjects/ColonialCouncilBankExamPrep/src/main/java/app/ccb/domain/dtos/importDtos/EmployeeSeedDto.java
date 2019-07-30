package app.ccb.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeSeedDto {
    @Expose
    @SerializedName(value = "full_name")
    private String fullName;
    @Expose
    private String salary;
    @Expose
    @SerializedName(value = "started_on")
    private String startedOn;
    @Expose
    @SerializedName(value = "branch_name")
    private String branchName;

    public EmployeeSeedDto() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(String startedOn) {
        this.startedOn = startedOn;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
