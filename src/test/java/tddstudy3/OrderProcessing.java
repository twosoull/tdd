package tddstudy3;

import java.util.List;

public class OrderProcessing {

    //1) 처음에 return true 던짐
    /*
    public boolean validQuantityAndStock(Product product, int quantity){

        return true;
    }
    */

    //1) 검증기 만들기
    public boolean validQuantityAndStock(Product product, int quantity){
        boolean result = product.getStock() >= quantity;
        return result;
    }

    // 음수가 들어오는 경우 (예:-1)
    public void checkQuantity(){

    }


}
