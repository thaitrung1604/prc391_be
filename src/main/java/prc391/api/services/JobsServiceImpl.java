package prc391.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prc391.lib.models.JobModel;
import prc391.lib.repositories.JobsRepository;

import java.util.List;

@Service
public class JobsServiceImpl implements JobsService {
    private final JobsRepository jobsRepository;

    @Autowired
    public JobsServiceImpl(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public List<JobModel> getJobList(String searchValue, Integer id, Integer ownerId) {
        return this.jobsRepository.getJobList(searchValue, id, ownerId);
    }

    @Override
    public int createPost(JobModel jobModel) {
        return this.jobsRepository.createPost(jobModel);
    }

    @Override
    public int updatePost(JobModel jobModel) {
        return this.jobsRepository.updatePost(jobModel);
    }

    @Override
    public int deletePost(Integer id) {
        return this.jobsRepository.deletePost(id);
    }
}
