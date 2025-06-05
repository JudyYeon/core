package judy.core;

import judy.core.discount.DiscountPolicy;
import judy.core.discount.FixDiscountPolicy;
import judy.core.member.MemberRepository;
import judy.core.member.MemberService;
import judy.core.member.MemberServiceImpl;
import judy.core.member.MemoryMemberRepository;
import judy.core.order.OrderService;
import judy.core.order.OrderServiceImpl;

public class AppConfig {

    // 메서드 명에서 역할이 드러나도록 해야함

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
