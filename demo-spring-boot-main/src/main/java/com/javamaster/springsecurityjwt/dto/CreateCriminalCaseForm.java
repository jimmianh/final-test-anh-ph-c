package com.javamaster.springsecurityjwt.dto;

import com.javamaster.springsecurityjwt.entity.CaseStatus;
import com.javamaster.springsecurityjwt.entity.CaseType;
import com.javamaster.springsecurityjwt.entity.CriminalCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCriminalCaseForm {

	@Column(length = 20, nullable = false, unique = false)
	@NotBlank(message = "nhập number")
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private CaseType type;

	private String shortDescription;

	private String detailDescription;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private CaseStatus status;

	public CriminalCase toEntity() {
		return new CriminalCase(number, type, shortDescription, detailDescription, status);
	}
}
