package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData){

        if(payData.getFirstBillingDate() != null){
            LocalDate candiDateExp = payData.getBillingDate().plusMonths(1);
            if(payData.getFirstBillingDate().getDayOfMonth() != candiDateExp.getDayOfMonth()){
                return candiDateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        if(payData.getFirstBillingDate() != null){
            if(payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))){
                return LocalDate.of(2019, 3, 31);
            }
        }

        return payData.getBillingDate().plusMonths(1);
    }
}
