package tddstudy3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessingTest {
    /*
    ##  전자 상거래 주문 처리 시스템
        목표 : 주문 처리를 위한 시스템을 구현합니다. 이 시스템은 세 가지 조건을 모두 만족해야 합니다:
        1. 유효한 상품 ID: 주문에 포함된 모든 상품 ID가 유효한지 확인합니다.
        2. 재고 확인: 주문한 수량이 재고보다 적거나 같아야 합니다.
        3. 주문 총액 계산: 주문 총액이 정확히 계산되어야 합니다.
        > 유효한 상품ID 검증 -> 재고 확인 검증 -> 주문 총액 값 리턴으로 기획을 정의했다.
        ----

        1) 읽어보니 상품 vo가 필요할것 같다.
        2) 상품에는 ID, 이름, 가격, 재고 값이 있어야 할 것 같다.
        3) 주문한 수량 값 비교 혹은 주문 총액 값이 쉬울 것 같다.
        4) 주문 총액 값 테스트를 먼저 하기로 했다.
        5) 하려다가 생각했다. 상품에 대한 재고가 적거나 같은걸 먼저 해야할 것 같다. 리스트가 아닌 한개를 먼저 해야함

    */

    private OrderProcessing od;//
    @BeforeEach
    void setUp() {
        od = new OrderProcessing();
    }

    //1) 주문한 수량 값 비교
    @Test
    void VerificationQuantityAndStock() {
        Product pdApple = new Product(1L, "사과", 1000, 2);

        int appleQuantity = 1;
        boolean result = od.validQuantityAndStock(pdApple, appleQuantity);
        Assertions.assertEquals(true, result);

        appleQuantity = 2;
        result = od.validQuantityAndStock(pdApple, appleQuantity);
        Assertions.assertEquals(true, result);

        appleQuantity = 3;
        result = od.validQuantityAndStock(pdApple, appleQuantity);
        Assertions.assertEquals(false, result);

    }


}
