package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨(){ //내용에 맞게 Test를 작성할 때에 외국인 작업자가 없으면 한글도 나쁘지 않다.
        assertExpiryDate(
                LocalDate.of(2019, 3, 1),10_000,
                LocalDate.of(2019, 4, 1));

        assertExpiryDate(
                LocalDate.of(2019, 5, 5),10_000,
                LocalDate.of(2019, 6, 5));
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate, payAmount);

        assertEquals(expectedExpiryDate,expiryDate2);
    }
}
