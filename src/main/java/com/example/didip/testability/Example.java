package com.example.didip.testability;

/*
Testability : 얼마나 쉽게 Input을 변경하고, Output을 쉽게 검증할 수 있는가 ?
 */
public class Example {
    // Testability 낮은사례 - [input - 외부 시스템] - 하드 코딩된 외부 시스템과 연동 되어있는 경우
    public void processDataV1(String data) {
        String processedData = data.toUpperCase(); //데이터 처리
        sendDataOberNetwork(processedData);
    }

    private void sendDataOberNetwork(String processedData) {
        // HTTP를 이용한 네트워크 요청
    }

    // Testability 낮은사례 - [output - 감춰진결과] - 외부에서 결과를 볼 수 없는경우
    public void processDataV2(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        //외부에서는 콘솔 출력된 값을 확인 할 수 없음
        System.out.println("Sum : " + sum);
    }

}
