package prc391.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import prc391.common.utils.GoogleUtils;
import prc391.common.utils.JwtTokenUtils;
import prc391.lib.models.JwtResponse;
import prc391.lib.models.UserModel;
import prc391.lib.models.common.BaseResponseModel;
import prc391.lib.models.common.GoogleResponse;
import prc391.lib.repositories.AuthenticationRepository;
import prc391.lib.repositories.UsersRepository;

import java.io.IOException;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationRepository authenticationRepository;
    private final GoogleUtils googleUtils;
    private final JwtTokenUtils jwtTokenUtils;
    private final UsersRepository usersRepository;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository,
                                     GoogleUtils googleUtils,
                                     JwtTokenUtils jwtTokenUtils,
                                     UsersRepository usersRepository) {
        this.authenticationRepository = authenticationRepository;
        this.googleUtils = googleUtils;
        this.jwtTokenUtils = jwtTokenUtils;
        this.usersRepository = usersRepository;
    }

    @Override
    public BaseResponseModel login(String tokenId) throws IOException {
        GoogleResponse userInfo = this.googleUtils.getUserInfo(tokenId);

        if (userInfo == null) {
            return new BaseResponseModel("Invalid user!");
        }

        int isUserExist = this.authenticationRepository.isUserExist(userInfo.getEmail());

        if (isUserExist == 0) {
            UserModel userModel = new UserModel();
            userModel.setEmail(userInfo.getEmail());
            userModel.setPhoto(userInfo.getPicture());
            userModel.setOrganizationName(userInfo.getName());
            userModel.setRoleId(1);

            this.usersRepository.registerAccount(userModel);
        }

        String jwtToken = this.jwtTokenUtils.generateJwtToken(userInfo.getEmail());
        JwtResponse response = new JwtResponse();
        response.setToken(jwtToken);
        return new BaseResponseModel(response);
    }

    @Override
    public BaseResponseModel checkAuthenUser(String token) {
        String email = this.jwtTokenUtils.getEmailFromJwtToken(token);
        if (email == null) {
            return new BaseResponseModel("Invalid user!");
        }

        List<UserModel> user = this.usersRepository.getUserDetail(email);

        if (user.isEmpty()) {
            return new BaseResponseModel("Invalid user!");
        }

        return new BaseResponseModel(user);
    }
}
