package prc391.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import prc391.lib.models.common.GoogleResponse;

import java.io.IOException;

@Component
public class GoogleUtils {
    @Autowired
    public Environment env;

    public GoogleResponse getUserInfo(final String idToken) throws IOException {
        String link = env.getProperty("google.link.get.user_info") + idToken;
        String response = Request.Get(link).execute().returnContent().asString();
        ObjectMapper mapper = new ObjectMapper();
        GoogleResponse googlePojo = mapper.readValue(response, GoogleResponse.class);

        return googlePojo;
    }

}
