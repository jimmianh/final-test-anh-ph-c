package com.javamaster.springsecurityjwt.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private String code;
	private String massage;
	private Object data;

}
