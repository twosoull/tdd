package tddstudy2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorTest {
    /*
    - 쇼핑몰 상품 할인 계산기
    목표: 주어진 상품 목록과 할인 규칙에 따라 최종 가격을 계산하는 기능을 구현합니다. 이 계산기는 다음 세 가지 조건을 모두 만족해야 합니다:

    1. 퍼센트 할인 적용: 각 상품에 대해 지정된 퍼센트 할인을 적용합니다.
    2. 최소 가격 보장: 할인 적용 후의 가격이 최소 가격을 밑돌지 않도록 합니다.
    3. 총 가격 계산: 모든 상품의 최종 가격을 합산하여 총 가격을 계산합니다.
     */

    /*
    * 1. 각각 테스트로만 만들 수도 있지만, 나에게 필요한 것은 계산기이다.
    * 2. 객체에 받아온 Product(상품)을 넣을 것이고, 객체 네이밍은  DiscountCalculator가 되면 될 것 같다.
    * 3. 1)3개의 테스트 중 총 가격 구하기가 쉬워보였다.
    * 4. 2)퍼센트 할인 적용이 쉬워보였다.
    * 5. 3)최소가격 보장을 마지막으로 했다.
    * 6. 4) 퍼센트와 최소가격을 구하는 로직을 함께 테스트 해야해서 로직을 추가했다.
    * 7. 역시나 의문점이 나왔다. 최소가격보다 값이 낮을 경우 사용자도 알아야 할 것이다. 메세지 표시가 필요하다.
    * */
    private DiscountCalculator discountCalculator = new DiscountCalculator();

    // 1. 처음에는 할인율이 적용되지 않았었다.
    /**
     * 1. 22000이 먼저 나오게 했으면 좋았을 것 같다. (하드로, 완벽하게 먼저 동작하는 것을 기준)
     * 2. 익셉션 처리
     * */
    @Test
    void 총_가격_계산() {
        Product 아디다스 = new Product("아디다스", 10000, 30, 6000);
        Product 나이키 = new Product("나이키", 20000, 30, 15000);
        //아디다스는 30퍼 할인이기 때문에 7000이 된다.
        //나이키는 30퍼 할인이면 14000이다. 하지만 최소가격이 15000이므로 15000원이 됌

        List<Product> productList = new ArrayList<>();
        productList.add(아디다스);
        productList.add(나이키);

        int totalPrice = discountCalculator.TotalProductCalculation(productList);
        //assertEquals(totalPrice,30000);
        assertEquals(totalPrice,22000);
    }

    @Test
    void 할인된_금액_계산() {
        Product 아디다스 = new Product("아디다스", 10000, 50, 6000);
        int discountedPrice1 = discountCalculator.discountProductCalculation(아디다스);
        assertEquals(discountedPrice1,5000);

        Product 나이키 = new Product("나이키", 20000, 30, 16000);
        int discountedPrice2 = discountCalculator.discountProductCalculation(나이키);
        assertEquals(discountedPrice2,14000);
    }

    //익셉션 처리

    @Test
    void 최소_가격_보장() {
        int result = discountCalculator.minimumPriceComparison(6000, 7000);
        assertEquals(result, 7000);

        int result2 = discountCalculator.minimumPriceComparison(8000, 6000);
        assertEquals(result2, 8000);
        
    }

    //익셉션 처리

    @Test
    void 상품_할인적용_및_최소가격보장() {
        Product 아디다스 = new Product("아디다스", 10000, 30, 6000);
        int result = discountCalculator.minComparisonAfterDiscount(아디다스);
        assertEquals(result,7000);
        Product 나이키 = new Product("나이키", 20000, 30, 15000);
        int result2 = discountCalculator.minComparisonAfterDiscount(나이키);
        assertEquals(result2,15000);
    }

    /////////////////////////////////////////////
    @Test
    void 총합가격_메세지_추가() {
        Product 아디다스 = new Product("아디다스", 10000, 30, 6000);
        Product 나이키 = new Product("나이키", 20000, 30, 15000);
        //아디다스는 30퍼 할인이기 때문에 7000이 된다.
        //나이키는 30퍼 할인이면 14000이다. 하지만 최소가격이 15000이므로 15000원이 됌

        List<Product> productList = new ArrayList<>();
        productList.add(아디다스);
        productList.add(나이키);

        Map<String, Object> stringObjectMap = discountCalculator.totalProductCalculationAndMessage(productList);
        List<Map<String, Object>> resultList = (List)stringObjectMap.get("resultList");

        for(int i = 0; i < resultList.size(); i++){
            Map<String, Object> map = resultList.get(i);
            boolean  hasMessage= (boolean)map.get("result");
            if(hasMessage){
                System.out.println(map.get("message"));
            }
        }
        assertEquals(stringObjectMap.get("totalPrice"),22000);
    }

}
