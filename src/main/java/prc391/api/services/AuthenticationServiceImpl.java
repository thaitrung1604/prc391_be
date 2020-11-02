package prc391.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prc391.common.utils.GoogleUtils;
import prc391.lib.models.common.BaseResponseModel;
import prc391.lib.models.common.GoogleResponse;
import prc391.lib.repositories.AuthenticationRepository;

import java.io.IOException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationRepository authenticationRepository;
    private final GoogleUtils googleUtils;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository, GoogleUtils googleUtils) {
        this.authenticationRepository = authenticationRepository;
        this.googleUtils = googleUtils;
    }

    @Override
    public BaseResponseModel login(String tokenId) throws IOException {
        GoogleResponse userInfo = this.googleUtils.getUserInfo(tokenId);

        if (userInfo == null) {
            return new BaseResponseModel("Invalid user!");
        }

        int isUserExist = this.authenticationRepository.isUserExist(userInfo.getEmail());

        if (isUserExist == 0) {
            return new BaseResponseModel("Invalid user!");
        }

        return null;
    }
}
