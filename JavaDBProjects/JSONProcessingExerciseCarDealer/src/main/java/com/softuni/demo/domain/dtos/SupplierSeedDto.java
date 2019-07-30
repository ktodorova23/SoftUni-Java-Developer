package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SupplierSeedDto implements Serializable {
    @Expose
    @NotNull(message = "Suppliers cannot have null as a name!")
    private String name;
    @Expose
    @NotNull(message = "There should be information weather a supplier is an importer or nor!")
    private boolean isImporter;

    public SupplierSeedDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
