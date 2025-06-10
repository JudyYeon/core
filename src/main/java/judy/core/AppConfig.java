package judy.core;

import judy.core.discount.DiscountPolicy;
import judy.core.discount.FixDiscountPolicy;
import judy.core.member.MemberRepository;
import judy.core.member.MemberService;
import judy.core.member.MemberServiceImpl;
import judy.core.member.MemoryMemberRepository;
import judy.core.order.OrderService;
import judy.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DI 컨테이너
 * 객체를 생성하고 관리하면서 의존관계를 연결한다.
 * = 오브젝트 팩토리로 불리기도 함.
 */
@Configuration
public class AppConfig {

    // 메서드 명에서 역할이 드러나도록 해야함
    // 단축키 cmd + e = 이전 히스토리 보여짐

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // memberRepository 1번
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository(); // 3번실행됨
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // memberRepository 2번
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
