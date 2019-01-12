package io.ejaz.ejazrestfulapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {
    @Id @GeneratedValue
    private long iD;

    @NotBlank(message = "Project Name is required !")
    private String projectName;

    @NotBlank(message = "Project Identifier is required !")
    @Size(min = 4,max = 5,message = "Please use 4 to 5 characters")
    @Column(updatable = false,unique = true)
    private String projectIdentifier;

    @NotBlank(message = "Project Description is required !")
    private String projectDescription;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date projectStartDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date projectEndDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date objectCreatedAt;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date objectUpdatedAt;

    public Project() {
        this.objectCreatedAt = new Date();
    }

    @PrePersist
    protected void onCreate(){
    }

    @PreUpdate
    protected void onUpdate(){
        this.objectUpdatedAt = new Date();
    }

    public long getiD() {
        return iD;
    }

    public void setiD(long iD) {
        this.iD = iD;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier.toUpperCase();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public Date getObjectCreatedAt() {
        return objectCreatedAt;
    }

    public void setObjectCreatedAt(Date objectCreatedAt) {
        this.objectCreatedAt = objectCreatedAt;
    }

    public Date getObjectUpdatedAt() {
        return objectUpdatedAt;
    }

    public void setObjectUpdatedAt(Date objectUpdatedAt) {
        this.objectUpdatedAt = objectUpdatedAt;
    }
}
