package com.javamaster.springsecurityjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@Entity
@Table(name = "CriminalCases")
@Getter
@Setter
@NoArgsConstructor
public class CriminalCase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "caseId")
	private Long Id;

	@Column(length = 20, nullable = false, unique = false)
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private CaseType type;
	private String shortDescription;
	private String detailDescription;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private CaseStatus status;
	private String notes;

	@OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Evidence> eviddence;
	private Detective leadlinvestigator;

	@ManyToOne
	@JoinColumn(name = "detectiveId")
	private Detective detective;

	@OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<WorkingDetecCrimi> workingDetecCrimis;

	public CriminalCase(String number, CaseType type, String shortDescription, String detailDescription,
			CaseStatus status) {
		this.number = number;
		this.type = type;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.status = status;

	}

}
