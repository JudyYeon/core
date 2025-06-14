package judy.core.discount;

import judy.core.annotation.MainDiscountPolicy;
import judy.core.member.Grade;
import judy.core.member.Member;
import org.springframework.stereotype.Component;

@Component
//@Primary // 우선순위지정 , 단축키 구현체 cmd + opt + B
//@Qualifier("mainDiscountPolicy") // 이렇게쓰면 문자 컴파일 오류를 놓칠 수 있다. 따라서 직접 만든 어노테이션 사용해줌
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    // 클래스명에서 단축키 ctrl + b = 사용하는 코드 추적
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        return 0;
    }
}
