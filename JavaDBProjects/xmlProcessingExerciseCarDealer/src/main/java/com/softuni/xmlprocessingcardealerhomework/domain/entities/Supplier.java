package com.softuni.xmlprocessingcardealerhomework.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
    @NotNull
    private String name;
    @NotNull
    @Column(name = "is_importer")
    private Boolean isImporter;

    @OneToMany(targetEntity = Part.class, mappedBy = "supplier", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Part> parts;

    public Supplier() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}

