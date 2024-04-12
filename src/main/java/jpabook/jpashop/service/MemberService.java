package jpabook.jpashop.service;

import java.util.List;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.MemberRepositoryOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // 테스트코드 만들때 편하려고 쓰는건가?
public class MemberService {

	private final MemberRepositoryOld memberRepositoryOld;
	private final MemberRepository memberRepository;

	//회원가입
	@Transactional
	public Long join(Member member) {

		validateDuplicateMember(member); //중복 회원 검증
		memberRepositoryOld.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		List<Member> findMember =
				memberRepository.findByName(member.getName());
		if (!findMember.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}

	//회원 전체 조회
	public List<Member> findMembers(){
		return memberRepositoryOld.findAll();
	}
	//회원 조회
	public Member findOne(Long memberId){
		return memberRepository.findById(memberId).get();
	}

	@Transactional
	public void update(Long id, String name) {

		Member member = memberRepositoryOld.findOne(id);
		member.setName(name);

	}
}
