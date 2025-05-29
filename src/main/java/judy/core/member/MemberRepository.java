package judy.core.member;

public interface MemberRepository {

    // 멤버 저장
    void save(Member member);

    // 아이디로 멤버 정보 찾기
    Member findById(Long memberId);
}
