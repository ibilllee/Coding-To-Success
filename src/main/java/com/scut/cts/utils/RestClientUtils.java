package com.scut.cts.utils;

import com.sun.tools.internal.ws.processor.model.Response;
import org.springframework.http.*;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class RestClientUtils {
    public static <T> String exchange(String url, HttpMethod method, Class<T> response, MultiValueMap<String,String> request) {
        HttpHeaders headers = new HttpHeaders();
        MimeType mimeType = MimeTypeUtils.parseMimeType("application/json");
        MediaType mediaType = new MediaType(mimeType.getType(), mimeType.getSubtype(), Charset.forName("UTF-8"));
        headers.setContentType(mediaType);

        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<MultiValueMap<String,String>>(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = (ResponseEntity<String>) restTemplate.exchange(url, method, entity, response);
        return responseEntity.getBody();
    }
}
