package prc391.lib.models;

import java.time.LocalDateTime;

import static prc391.common.utils.DateTimeUtils.dateTimeToString;

public class JobModel {
    private int id;
    private String name;
    private String description;
    private double salary;
    private String interviewDescription;
    private String postedDate;
    private int ownerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getInterviewDescription() {
        return interviewDescription;
    }

    public void setInterviewDescription(String interviewDescription) {
        this.interviewDescription = interviewDescription;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = dateTimeToString(postedDate);
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
