package judy.core;

import judy.core.member.MemberService;
import judy.core.member.MemberServiceImpl;
import judy.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }


}
