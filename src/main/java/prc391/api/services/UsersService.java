package prc391.api.services;

import org.springframework.stereotype.Service;
import prc391.lib.models.UserModel;

import java.util.List;

public interface UsersService {
    int registerAccount(UserModel userDetail);
    List<UserModel> getUserDetail(String email, Integer id);
    int updateUserInfo(UserModel userModel);
    int deleteUser(Integer id);
}
