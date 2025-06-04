package judy.core.member;

/**
 * 회원 서비스 객체
 */
public class MemberServiceImpl implements MemberService{

    // 구현체가 하나만 있을 때는 인터페이스명 xxxxImpl 이라고 명명한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
