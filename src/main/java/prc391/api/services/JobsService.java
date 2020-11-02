package prc391.api.services;

import prc391.lib.models.JobModel;

import java.util.List;

public interface JobsService {
    List<JobModel> getJobList(String searchValue, Integer id, Integer onwerId);
    int createPost(JobModel jobModel);
    int updatePost(JobModel jobModel);
    int deletePost(Integer id);
}
