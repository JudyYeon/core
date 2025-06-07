package judy.core;

import judy.core.member.Grade;
import judy.core.member.Member;
import judy.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // AnnotationConfigApplicationContext 안에 설정파일을 적어준다. 스프링 어노테이션들이 찾아옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 기본 : 메서드명, 빈으로 등로간 것을 찾아와줌

        Member member = new Member(1L, "memberA", Grade.VIP); // ctrl + alt + v = new Member에 대한 정의를 자동완성
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName()); // sout + v
        System.out.println("find member = " + findMember.getName());
    }
}
