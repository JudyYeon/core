package judy.core.order;

import judy.core.discount.DiscountPolicy;
import judy.core.discount.FixDiscountPolicy;
import judy.core.member.Member;
import judy.core.member.MemberRepository;
import judy.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // final = 반드시 값을 할당해야함. null 금지
    // 인터페이스 - 구현체 조합으로 의존
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**
     * 주문 생성하기
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
