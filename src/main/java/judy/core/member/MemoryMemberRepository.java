package judy.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 예제이므로 감안하고 HashMap<>()사용
    // 실무에서는 동시성의 이슈가 있기 때문에 ConcurrentHashMap 사용
    private static Map<Long, Member> store = new HashMap<>();


    // 예제이므로 내부 메서드의 오류 처리를 생략함.
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
