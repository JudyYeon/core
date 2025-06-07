package judy.core;

import judy.core.member.Grade;
import judy.core.member.Member;
import judy.core.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP); // ctrl + alt + v = new Member에 대한 정의를 자동완성
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName()); // sout + v
        System.out.println("find member = " + findMember.getName());
    }
}
