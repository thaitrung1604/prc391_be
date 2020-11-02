package prc391.lib.repositories;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import prc391.lib.models.JobModel;

import java.util.List;

@Mapper
public interface JobsRepository {

    @Select({
            "<script>" +
                    "SELECT " +
                    "    id as id, " +
                    "    name as name, " +
                    "    description as description, " +
                    "    salary as salary, " +
                    "    interview_description as interviewDescription, " +
                    "    posted_date as postedDate, " +
                    "    owner_id as ownerId " +
                    "FROM " +
                    "    tbl_job " +
                    "<if test='searchValue != null'>" +
                    "WHERE " +
                    "    name LIKE '%${searchValue}%'" +
                    "</if>" +
                    "<if test='id != null'>" +
                    "WHERE " +
                    "   id = #{id}" +
                    "</if>" +
                    "<if test='ownerId != null'>" +
                    "WHERE " +
                    "   owner_id = #{ownerId}" +
                    "</if>" +
                    "</script>"
    })
    List<JobModel> getJobList(@Param("searchValue") String searchValue, @Param("id") Integer id, @Param("ownerId") Integer ownerId);

    @Insert({
            "INSERT INTO tbl_job " +
                    "    (name, " +
                    "     description, " +
                    "     salary, " +
                    "     interview_description, " +
                    "     owner_id) " +
                    "     values (#{job.name}, " +
                    "             #{job.description}, " +
                    "             #{job.salary}, " +
                    "             #{job.interviewDescription}, " +
                    "             #{job.ownerId})"
    })
    int createPost(@Param("job") JobModel jobModel);
    
    @Update({
            "UPDATE tbl_job SET name = #{job.name}, " +
                    "                   description = #{job.description}, " +
                    "                   salary = #{job.salary}, " +
                    "                   interview_description = #{job.interviewDescription}, " +
                    "                   posted_date = getdate() " +
                    "WHERE id = #{job.id}"
    })
    int updatePost(@Param("job") JobModel jobModel);

    @Delete({
            "DELETE FROM tbl_job WHERE id = #{id}"
    })
    int deletePost(@Param("id") int id);
}
