package prc391.lib.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthenticationRepository {
    @Select({
        "SELECT count(*) FROM tbl_user WHERE email = #{email}"
    })
    int isUserExist(@Param("email") String email);
}
