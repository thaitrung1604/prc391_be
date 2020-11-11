package prc391.lib.repositories;

import org.apache.ibatis.annotations.*;
import prc391.lib.models.UserModel;

import java.util.List;

@Mapper
public interface UsersRepository {

    @Insert({
            "INSERT INTO tbl_user " +
                    "    (organization_name, " +
                    "     email, " +
                    "     phone_number, " +
                    "     address, " +
                    "     role_id) " +
                    "    values (#{user.organizationName}, " +
                    "            #{user.email}, " +
                    "            #{user.phoneNumber}, " +
                    "            #{user.address}, " +
                    "            #{user.roleId})"
    })
    int registerAccount(@Param("user") UserModel userDetail);

    @Select({
            "<script>" +
                    "SELECT " +
                    "    id as id, " +
                    "    organization_name as organizationName, " +
                    "    email as email, " +
                    "    phone_number as phoneNumber, " +
                    "    address as address, " +
                    "    role_id as roleId, " +
                    "    photo as photo " +
                    "FROM " +
                    "    tbl_user " +
                    "<if test='email != null'>" +
                    "WHERE " +
                    "    email = #{email}" +
                    "</if>" +
                    "</script>"
    })
    List<UserModel> getUserDetail(@Param("email") String email);

    @Select({
            "SELECT " +
                    "    id as id, " +
                    "    organization_name as organizationName, " +
                    "    email as email, " +
                    "    phone_number as phoneNumber, " +
                    "    address as address, " +
                    "    role_id as roleId, " +
                    "    photo as photo " +
                    "FROM " +
                    "    tbl_user " +
                    "WHERE " +
                    "    id = #{id}"
    })
    List<UserModel> getUserById(@Param("id") int id);

    @Update({
            "UPDATE tbl_user SET organization_name = #{user.organizationName}, " +
                    "                   email = #{user.email}, " +
                    "                   phone_number = #{user.phoneNumber}, " +
                    "                   address = #{user.address}, " +
                    "                   photo = #{user.photo} " +
                    "WHERE id = #{user.id}"
    })
    int updateUserInfo(@Param("user") UserModel userModel);

    @Delete({
            "DELETE FROM tbl_user WHERE id = #{id}"
    })
    int deleteUser(@Param("id") int id);
}
