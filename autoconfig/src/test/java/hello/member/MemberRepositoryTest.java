package hello.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired private MemberRepository memberRepository;

	@Transactional
	@Test
	void memberTest() {
		// given
		Member member = new Member("idA", "memberA");

		// when
		memberRepository.initTable();
		memberRepository.save(member);
		Member findMember = memberRepository.find(member.getMemberId());

		// then
		assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
		assertThat(findMember.getName()).isEqualTo(member.getName());
	}

}
