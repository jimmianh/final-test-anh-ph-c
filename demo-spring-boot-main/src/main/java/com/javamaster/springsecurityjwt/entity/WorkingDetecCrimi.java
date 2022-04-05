package com.javamaster.springsecurityjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Working_Detec_Crimis")
public class WorkingDetecCrimi {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long Id;

	@ManyToOne
	@MapsId
	@JoinColumn(name = "caseId")
	private CriminalCase criminalCase;

	@ManyToOne
	@JoinColumn(name = "detectiveId")
	private Detective detective;

}
