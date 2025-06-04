package judy.core;

import judy.core.discount.FixDiscountPolicy;
import judy.core.member.MemberService;
import judy.core.member.MemberServiceImpl;
import judy.core.member.MemoryMemberRepository;
import judy.core.order.OrderService;
import judy.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
