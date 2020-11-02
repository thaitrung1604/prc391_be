package prc391.lib.models;

import java.util.List;

public class JobDetailModel {
    private UserModel user;
    private List<JobModel> job;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<JobModel> getJob() {
        return job;
    }

    public void setJob(List<JobModel> job) {
        this.job = job;
    }
}
