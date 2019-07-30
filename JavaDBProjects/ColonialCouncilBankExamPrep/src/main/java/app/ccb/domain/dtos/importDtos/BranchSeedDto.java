package app.ccb.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;

public class BranchSeedDto {
    @Expose
    private String name;

    public BranchSeedDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
