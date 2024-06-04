package tddstudy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorVerificationTest {
    // 먼저 생성기의 네이밍을 고민했다. 1차원 적으로 로또번호생성기를 번역하면 LottoNumberGenerator가 된다.
    // 로또 생성기를 테스트하려면 어떻게 해야할까?
    // 고유한 번호는 테스트할 로직이 너무 길다.
    // 번호 범위는 하드코딩으로 해도 괜찮을 것 같다.
    // 번호 갯수도 하드로 진행해도 괜찮을 것 같다.
    // 먼저해야 되는 테스트 순서로 나열해 보았다.
    // 1. 6개 갯수 테스트
    // 2. 1~45 이외의 숫자가 있는가?
    // 2-1. 45보다 큰가
    // 2-2. 1보다 작은가
    // 2-3. 내가 의도한 실패가 맞는지 sysout 찍어보기
    // 2-4. 1~45일 때는 성공인지 확인
    // 3. 중복되는 번호가 있는가?

    LottoNumberGenerator lng = new LottoNumberGenerator();

    @Test
    void lengthCriteria() {
        int[] nums = lng.createLottoNumber();
        Assertions.assertEquals(nums.length, 6);
    }

    @Test
    void rangeCriteria() {
        int[] nums = lng.createLottoNumber();

        Boolean isRangeCriteria = Boolean.TRUE;
        for (int i = 0; i < nums.length; i++) {
            if (45 < nums[i]) {
                isRangeCriteria = Boolean.FALSE;
                System.out.println("[" + i + "]의 숫자가 45보다 큽니다.");
                break;
            }
            if (1 > nums[i]) {
                isRangeCriteria = Boolean.FALSE;
                System.out.println("[" + i + "]의 숫자가 1보다 작습니다.");
                break;
            }
        }
        Assertions.assertEquals(isRangeCriteria, Boolean.TRUE);
    }

    @Test
    void uniqueCriteria() {
        int[] nums = lng.createLottoNumber();
        Assertions.assertEquals(6, nums.length);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Assertions.assertNotEquals(nums[i], nums[j]);
            }
        }
    }
}
