package prc391.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prc391.lib.models.UserModel;
import prc391.lib.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public int registerAccount(UserModel userDetail) {
        return this.usersRepository.registerAccount(userDetail);
    }

    @Override
    public List<UserModel> getUserDetail(String email, Integer id) {
        if (id != null) {
            return this.usersRepository.getUserById(id);
        } else {
            return this.usersRepository.getUserDetail(email);
        }
    }

    @Override
    public int updateUserInfo(UserModel userModel) {
        return this.usersRepository.updateUserInfo(userModel);
    }

    @Override
    public int deleteUser(Integer id) {
        return this.usersRepository.deleteUser(id);
    }
}
