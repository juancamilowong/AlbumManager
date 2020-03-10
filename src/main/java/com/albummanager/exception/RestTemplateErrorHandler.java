package com.albummanager.exception;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateErrorHandler implements ResponseErrorHandler{

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return new DefaultResponseErrorHandler().hasError(response);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            System.out.println(response.getRawStatusCode());
            System.out.println(response.getStatusCode());

        } else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            System.out.println(response.getRawStatusCode());
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            HttpHeaders headers = response.getHeaders();
            System.out.println(headers.get("Content-Type"));
            System.out.println(headers.get("Server"));
        }
	}
	
//	@Override
//    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
//		String responseAsString = response.getBody().toString();
//        System.out.println(String.format("URL: %s, HttpMethod: %s, ResponseBody: %s", url, method, responseAsString));
//
//        throw new CustomException(responseAsString);
//    }
//	
//	static class CustomException extends IOException {
//        
//		private static final long serialVersionUID = 1L;
//
//		public CustomException(String message) {
//            super(message);
//        }
//    }

}
