package jpabook.jpashop.springdata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Memberdata {

	@Id
	@GeneratedValue
	@Column(name = "memberdata_id")
	private Long id;

	private String username;

	private int age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teamdata_id")
	private Team team;

	public Memberdata(String username) {
		this(username, 0);
	}

	public Memberdata(String username, int age) {
		this(username, age, null);
	}

	public Memberdata(String username, int age, Team team) {
		this.username = username;
		this.age = age;
		if (team != null) {
			changeTeam(team);
		}
	}

	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}
}