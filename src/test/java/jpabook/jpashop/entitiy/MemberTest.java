package jpabook.jpashop.entitiy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import jpabook.jpashop.springdata.Memberdata;
import jpabook.jpashop.springdata.Team;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberTest {

	@PersistenceContext
	EntityManager em;

	@Test
	@Transactional
	@Rollback(false)
	public void testEntity() {
		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");
		em.persist(teamA);
		em.persist(teamB);
		Memberdata member1 = new Memberdata("member1", 10, teamA);
		Memberdata member2 = new Memberdata("member2", 20, teamA);
		Memberdata member3 = new Memberdata("member3", 30, teamB);
		Memberdata member4 = new Memberdata("member4", 40, teamB);
		em.persist(member1);
		em.persist(member2);
		em.persist(member3);
		em.persist(member4);
		//초기화
		em.flush();
		em.clear();
		//확인
		List<Memberdata> members = em.createQuery("select m from Member m",
						Memberdata.class)
				.getResultList();
		for (Memberdata member : members) {
			System.out.println("member=" + member);
			System.out.println("-> member.team=" + member.getTeam());
		}
	}
}