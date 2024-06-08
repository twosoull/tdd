package tddstudy2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountCalculator {

    //1. 처음에는 할인율이 적용되지 않는 목적으로 만듬
    //3. 할인된 금액으로 총 합을 더해주었다.
    public int TotalProductCalculation(List<Product> products) {

        int totalPrice = 0;
        for(Product product : products){
            //totalPrice += product.getPrice();
            //3.
            //totalPrice += discountProductCalculation(product);

            //5. 테스트가 완료 최소금액계산 기능을 넣어준다.
            //int result = discountProductCalculation(product);
            //totalPrice += minimumPriceComparison(result, product.getMin_price());
            //7. 위의 해당 로직이 제대로 작동하는지 테스트를 만들 수 없었다.
            //8.minComparisonAfterDiscount를 만들어 테스트 후 로직을 붙여줬다.
            totalPrice += minComparisonAfterDiscount(product);
        }

        return totalPrice;
    }
     
    //2. TotalProductCalculation에 할인율을 넣으려 했지만, 오히려 각각 기능별 메소드로 구한 뒤에 묶는것이
    // 테스트 목적으로도 좋다고 생각이 들었다.
    public int discountProductCalculation(Product product) {

        double discountedAmount = (product.getPrice() / 100) * product.getDiscount();
        double discountedPrice= product.getPrice() - discountedAmount;

        return (int)discountedPrice;
    }

    //4. 최소 가격 보장을 해야한다. discount된 금액과 minPrice를 나누어서 최소가격보다 작으면 최소가격을 줘야한다.
    public int minimumPriceComparison(int discountedPrice, int minPrice) {

        int result = discountedPrice <= minPrice ? minPrice : discountedPrice;

        return result;
    }

    //6. 상품 하나가 할인율이 적용 된 후에 최소가격과 비교해야함
    public int minComparisonAfterDiscount(Product product){
        int result = discountProductCalculation(product);
        return minimumPriceComparison(result,product.getMin_price());
    }

    ///////////////////////////////////////////////////////////////////
    //8. 메세지 만들기 및 값 조합해주기
    public Map<String,Object> ComparisonResult(int price, Product product){
        boolean result = price <= product.getMin_price() ? true : false;

        Map<String,Object> resultMap = new HashMap<>();
        if(result) {
            int resultPrice = minimumPriceComparison(price, product.getMin_price());

            resultMap.put("result", Boolean.TRUE);
            resultMap.put("price", resultPrice);
            resultMap.put("message", product.getName().concat("의 할인율을 넘어 최소값으로 표시됩니다."));
            return resultMap;
        }
        resultMap.put("result", Boolean.FALSE);
        resultMap.put("price",price);
        return resultMap;
    }

    //6. 상품 하나가 할인율이 적용 된 후에 최소가격과 비교해야함
    public Map<String, Object> minComparisonAfterDiscountAddMessage(Product product){
        int result = discountProductCalculation(product);
        return ComparisonResult(result,product);
    }

    public Map<String, Object> totalProductCalculationAndMessage(List<Product> products) {

        int totalPrice = 0;
        List<Map<String, Object>> list = new ArrayList<>();
        for(Product product : products){
            Map<String, Object> resultMap = minComparisonAfterDiscountAddMessage(product);
            totalPrice += minComparisonAfterDiscount(product);
            list.add(resultMap);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("resultList", list);
        result.put("totalPrice", totalPrice);

        return result;
    }
}
