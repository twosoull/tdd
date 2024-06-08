package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData){

        int addedMonths = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;

        if(payData.getFirstBillingDate() != null){
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candiDateExp = payData.getBillingDate().plusMonths(addedMonths);

        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();

        if(isSameDayOfMonth(candiDateExp, dayOfFirstBilling)){
            final int dayLenOfCandiMon = lastDayOfMonth(candiDateExp);
            if(dayLenOfCandiMon < dayOfFirstBilling) {
                return candiDateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candiDateExp.withDayOfMonth(dayOfFirstBilling);
        }else{
            return candiDateExp;
        }
    }

    private int lastDayOfMonth(LocalDate candiDateExp) {
        return YearMonth.from(candiDateExp).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(LocalDate candiDateExp, int dayOfFirstBilling) {
        return dayOfFirstBilling != candiDateExp.getDayOfMonth();
    }
}
