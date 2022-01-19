package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

public class BaseResponse<T> extends ResponseEntity<BaseResponse.ResponseBody<T>>{
    
    public BaseResponse(HttpStatus status,String message,T data)
    {
        super(new ResponseBody<>(status.value(),message,data),status);
    }
    public BaseResponse(HttpStatus status,String message)
    {
        super(new ResponseBody<>(status.value(),message),status);
    }
    @Data
    @AllArgsConstructor
    public static class ResponseBody<T> {
        @JsonProperty("status")
        private int code;

        @JsonProperty("message")
        private String message;

        @JsonProperty("data")
        private T data;

        public ResponseBody(int code, String msg) {
			super();
			this.code = code;
			this.message = msg;
	
		}
    }
}
