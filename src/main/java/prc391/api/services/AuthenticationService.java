package prc391.api.services;

import org.springframework.stereotype.Service;
import prc391.lib.models.common.BaseResponseModel;

import java.io.IOException;

public interface AuthenticationService {
    BaseResponseModel login(String tokenId) throws IOException;
}
