package judy.core.order;

public interface OrderService {

    // 주문생성
    Order create(Long memberId, String itemName, int itemPrice);
}
