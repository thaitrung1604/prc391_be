package prc391.api.services;

import org.springframework.stereotype.Service;
import prc391.lib.models.UserModel;

public interface UsersService {
    int registerAccount(UserModel userDetail);
    UserModel getUserDetail(String email, Integer id);
    int updateUserInfo(UserModel userModel);
    int deleteUser(Integer id);
}
