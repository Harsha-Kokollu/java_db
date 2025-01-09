package org.studyeasy.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/access-token")
public class AccessTokenController {

    private final String BASE_URL = "https://api.us.onelogin.com/";
    private final String CLIENT_ID = "0ee1153edfdc30f7cdb9c5bb2f7a96575faadcac62e37bbf66566d59acf2df96";
    private final String CLIENT_SECRET = "edae8332e57ade1ab0c41a263e8e6991bfc2ad5982e37c6afd97209378ea6cab";

    private final RestTemplate restTemplate = new RestTemplate();

    // CREATE - Generate Access Token
    @PostMapping("/generate")
    public Map<String, Object> generateAccessToken() {
        // Set up the body for the request
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("grant_type", "client_credentials");
        requestBody.put("client_id", CLIENT_ID);
        requestBody.put("client_secret", CLIENT_SECRET);

        // Create HTTP entity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // Make POST request using RestTemplate
        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                BASE_URL + "auth/oauth2/v2/token",
                HttpMethod.POST,
                entity,
                Map.class
        );

        // Parse response
        int statusCode = responseEntity.getStatusCodeValue();
        Map<String, Object> result = new HashMap<>();
        result.put("statusCode", statusCode);

        if (statusCode == 200) {
            Map<String, String> responseBody = responseEntity.getBody();
            String accessToken = responseBody != null ? responseBody.get("access_token") : null;
            result.put("accessToken", accessToken);
        } else {
            result.put("error", responseEntity.getBody());
        }

        return result;
    }
}
