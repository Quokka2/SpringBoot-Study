package jpabook.jpashop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

//@SpringBootTest
//@Transactional
//@Rollback(false)
//public class MemberJpaRepositoryTest {
//	@Autowired
//	MemberJpaRepository memberJpaRepository;
//	@Test
//	public void testMember() {
//		Member member = new Member("memberA");
//		Member savedMember = memberJpaRepository.save(member);
//		Member findMember = memberJpaRepository.find(savedMember.getId());
//		assertThat(findMember.getId()).isEqualTo(member.getId());
//		assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//		assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
//	}
//}
