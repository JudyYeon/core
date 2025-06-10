package judy.core.order;

import judy.core.AppConfig;
import judy.core.member.Grade;
import judy.core.member.Member;
import judy.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

   /* @Test
    void fieldInjectionTest(){
        OrderServiceImpl orderService = new OrderServiceImpl();
        // 이 부분에 setter 추가로 주입해주고,.. Member 객체를 만들어줘야함

        orderService.createOrder(1L, "itemA", 10000);
        // createOrder에서 memberRepository 객체 호출 시 null 이라 오류남

    }*/
}
