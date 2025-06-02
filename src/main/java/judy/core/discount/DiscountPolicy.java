package judy.core.discount;

import judy.core.member.Member;

/**
 * 할인 정책 클래스
 */
public interface DiscountPolicy {

    /**
     *
     * @return 할인대상 금액
     */
    int discount(Member member, int price);
}
