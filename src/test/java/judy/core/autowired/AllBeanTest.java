package judy.core.autowired;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import judy.core.AutoAppConfig;
import judy.core.discount.DiscountPolicy;
import judy.core.member.Grade;
import judy.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        // Bean 에서 할인 로직 객체를 가져온다.
        DiscountService discountService = ac.getBean(DiscountService.class);
        // 멤버 객체 생성
        Member member = new Member(1L, "userA", Grade.VIP);
        // 할인금액 계산
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");

        assertThat(rateDiscountPrice).isEqualTo(2000);

    }

    /**
     * 빈주입을 위해 테스트용 서비스 추가
     */
    static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

         // 생성자가 하나라 @Autowired 생략가능
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        /**
         * 할인 서비스
         * @return 할인 금액
         */
        public int discount(Member member, int price, String discountCode) {
            // Bean Map 에서 빈 이름과 동일한 할인 정책 객체를 가져온다.
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);

            return discountPolicy.discount(member, price);
        }
    }
}
