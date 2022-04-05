package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.dto.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.Detective;

public interface IDetectiveService {

	Detective getDetectiveById(Long Id);

	ResponseDTO createDetective(Detective detective);

	ResponseDTO updateDetective(Detective detective);

	void deleteDetectiveById(Long Id);

}
