package com.javamaster.springsecurityjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Evidences")
public class Evidence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "evidenceId")
	private Long evidenceId;

	@ManyToOne
	@JoinColumn(name = "caseId")
	private CriminalCase criminalCase;

	@ManyToOne
	@JoinColumn(name = "storageId")
	private Storage storage;
	@Column(name = "number", unique = false)
	@Length(max = 20)
	private String number;

	private String itemName;

	private String notes;

	private Boolean archived;

	@OneToMany(mappedBy = "evidence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TrackEntry> trackEntries;

}
