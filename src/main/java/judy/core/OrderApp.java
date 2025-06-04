package judy.core;

import judy.core.member.Grade;
import judy.core.member.Member;
import judy.core.member.MemberService;
import judy.core.member.MemberServiceImpl;
import judy.core.order.Order;
import judy.core.order.OrderService;
import judy.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
