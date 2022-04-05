package com.javamaster.springsecurityjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "detectives")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Detective implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "detectiveId")
	private Long detectiveId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personId")
	private Person person;
	
	@Column(name = "badgeNumber", unique = false)
	private String badgeNumber;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Ranks ranks;

	private Boolean amed;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EmploymentStatus status;

	@OneToMany(mappedBy = "detective", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<CriminalCase> criminalCases;

	@OneToMany(mappedBy = "detective", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TrackEntry> trackEntries;

	@OneToMany(mappedBy = "detective", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<WorkingDetecCrimi> workingDetecCrimis;

}
