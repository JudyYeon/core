package judy.core.member;

/**
 * 회원 서비스 인터페이스
 */
public interface MemberService {

    // 회원가입
    void join(Member member);

    // 멤버찾기
    Member findMember(Long memberId);
}
