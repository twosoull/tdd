package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨(){ //내용에 맞게 Test를 작성할 때에 외국인 작업자가 없으면 한글도 나쁘지 않다.
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 4, 1));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 2, 28));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 2, 28)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부(){
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 30))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 3, 30)

        );
        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 5, 31))
                .billingDate(LocalDate.of(2019, 6, 30))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData3, LocalDate.of(2019,7, 31));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2019, 5, 1)
        );

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2019, 6, 1)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2019, 4, 30)
        );
    }

    @Test
    void 십만원을_납부하면_1년_제공() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2020, 1, 28)
        );
    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal.calculateExpiryDate(payData);

        assertEquals(expectedExpiryDate,expiryDate2);
    }
}
