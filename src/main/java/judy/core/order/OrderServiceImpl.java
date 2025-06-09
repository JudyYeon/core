package judy.core.order;

import judy.core.discount.DiscountPolicy;
import judy.core.member.Member;
import judy.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")// @Service 라는 것도 있는데 별 기능을 수행하진 않지만 트랜잭션 어노테이션 시작과 끝에 관련있음, 개발자에게 서비스라고 명시적으로 이해
public class OrderServiceImpl implements OrderService{
    // final = 반드시 값을 할당해야함. null 금지
    // 인터페이스 - 구현체 조합으로 의존
    private MemberRepository memberRepository;

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 문제발생 구간..!

    // 새로운 할인 정책이 나왔다면 OrderServiceImpl 소스를 변경해야한다.
    //  private final DiscountPolicy discountPolicy = new 이 부분에 변경되는 정책 구현체();
    // 역할과 구현을 충실하게 분리했는가?
    // 다형성도 활용하고, 인터페이스와 구현객체를 분리했는가? -- No
    // 추상인터페이스에 의존하지만 구현 클래스에도 의존하고 있음... 기능확장시 클라이언트 코드에 영향을 준다 > OCP 위반
    private DiscountPolicy discountPolicy;

    // 생성자
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 주문 생성하기
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
