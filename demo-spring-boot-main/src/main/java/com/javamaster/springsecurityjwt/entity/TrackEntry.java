package com.javamaster.springsecurityjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TrackEntrys")
public class TrackEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trackEntryId")
	private Long trackEntryId;
	private LocalDateTime date;

	@ManyToOne
	@JoinColumn(name = "evidenceId")
	private Evidence evidence;

	@ManyToOne
	@JoinColumn(name = "detectiveId")
	private Detective detective;


	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private TrackAction action;

	private String reason;

}
