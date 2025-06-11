package judy.core.order;

import judy.core.discount.FixDiscountPolicy;
import judy.core.member.Grade;
import judy.core.member.Member;
import judy.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    @DisplayName("스프링 없이 순수하게 자바코드로 서비스테스트를 구현하는 경우")
    void createOrder(){

        // 스프링 빈을 이용하지 않으니 직접 구현체를 찾아 사용해야함
        // 이렇게 사용하는 경우도 종종필요함
        // 생성자 주입이 있으면 좋은 이유
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();

        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}