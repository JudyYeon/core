package judy.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 회원 서비스 객체
 */
@Component
public class MemberServiceImpl implements MemberService{

    // 구현체가 하나만 있을 때는 인터페이스명 xxxxImpl 이라고 명명한다.
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
// 여기도 직접 정해줬네~~... >> AppConfig 한테 맡기자

    private final MemberRepository memberRepository;

    @Autowired // @Component 를 통해 자동 빈 등록 시 구현체를 명시할 생성자가 없으므로 @Autowired 해야함 -> ac.getBean(MemberRepository.class);
    public MemberServiceImpl(MemberRepository memberRepository) { // 추상화에만 집중할 수 있게 생성자 주입
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
