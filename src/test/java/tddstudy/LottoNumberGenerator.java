package tddstudy;

import java.security.SecureRandom;

public class LottoNumberGenerator {

    //1.[실패]6개 갯수 케이스 테스트
//    public int[] createLottoNumber(){
//        int[] lottoNumbers = {1,2,3,4,5};
//        return lottoNumbers;
//    }

    //2.[성공] 6개 갯수 케이스 테스트
//    public int[] createLottoNumber(){
//        int[] lottoNumbers = {1,2,3,4,5,6};
//        return lottoNumbers;
//    }

    //java에는 random 숫자 만들기가 있으므로 아직 함수를 만들지 않음

    //3.[실패] 1~45 번호 범위 케이스 테스트
    //1번케이스 45보다 큰가?
//    public int[] createLottoNumber(){
//        int[] lottoNumbers = {1,2,3,4,5,50};
//        return lottoNumbers;
//    }

    //4.[실패] 1~45 번호 범위 케이스 테스트
    //2번케이스 1보다 작은가?
/*    public int[] createLottoNumber(){
        int[] lottoNumbers = {0,2,3,4,5,45};
        return lottoNumbers;
    }*/

    //5.[성공] 1~45 번호 범위 케이스 테스트
//    public int[] createLottoNumber(){
//        int[] lottoNumbers = {1,2,3,4,5,45};
//        return lottoNumbers;
//    }

    //6.[성공] 1~45 번호 범위와 6개 갯수 케이스 테스트
/*    public int[] createLottoNumber() {

        SecureRandom secureRandom = new SecureRandom();

        int[] lottoNumbers = new int[6];
        for(int i = 0 ; i < 6; i++){
            int randomNumber = secureRandom.nextInt(45) + 1; // 0에서 44까지 랜덤생성 후 +1
            lottoNumbers[i] = randomNumber;
        }
        return lottoNumbers;
    }*/

    //7. [실패] 중복 숫자 케이스 테스트
/*    public int[] createLottoNumber(){
        int[] lottoNumbers = {1,2,3,4,45,45};
        return lottoNumbers;
    }*/
    //8. [성공] 중복 숫자 케이스 테스트
//    public int[] createLottoNumber(){
//        int[] lottoNumbers = {1,2,3,4,5,45};
//        return lottoNumbers;
//    }

    public int[] createLottoNumber(){
        Boolean isUniqueCriteria = Boolean.FALSE;
        int[] lottoNumbers = new int[6];
        for(int i = 0; i < 1; i++){
            if(!isUniqueCriteria){
                SecureRandom secureRandom = new SecureRandom();
                for(int j = 0 ; j < 6; j++){
                    int randomNumber = secureRandom.nextInt(45) + 1; // 0에서 44까지 랜덤생성 후 +1
                    lottoNumbers[j] = randomNumber;
                }
                isUniqueCriteria = createRandom6Nums(lottoNumbers);
                i--;
            }
        }
        return lottoNumbers;
    }

    public Boolean createRandom6Nums(int[] lottoNumbers){
        Boolean result = Boolean.TRUE;

        for(int i = 0; i < lottoNumbers.length; i++){
            for(int j = 0; j < lottoNumbers.length; j++){
                if(i != j){
                    if(lottoNumbers[i] == lottoNumbers[j]){
                        result = Boolean.FALSE;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
