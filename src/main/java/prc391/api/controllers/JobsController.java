package prc391.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prc391.api.services.JobsService;
import prc391.lib.models.JobModel;
import prc391.lib.models.common.BaseResponseModel;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
    private final JobsService jobsService;

    @Autowired
    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponseModel> getJobList(@RequestParam(value = "searchValue", required = false) final String searchValue,
                                                        @RequestParam(value = "id", required = false) final Integer id,
                                                        @RequestParam(value = "ownerId", required = false) final Integer ownerId) {
        List<JobModel> result = this.jobsService.getJobList(searchValue, id, ownerId);

        if (result.isEmpty()) {
            return ResponseEntity.ok(new BaseResponseModel("Job not found!"));
        }

        return ResponseEntity.ok(new BaseResponseModel(result));
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponseModel> createPost(@RequestBody final JobModel jobModel) {
        return ResponseEntity.ok(new BaseResponseModel(this.jobsService.createPost(jobModel)));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponseModel> updatePost(@RequestBody final JobModel jobModel) {
        return ResponseEntity.ok(new BaseResponseModel(this.jobsService.updatePost(jobModel)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponseModel> deletePost(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(new BaseResponseModel(this.jobsService.deletePost(id)));
    }


}
