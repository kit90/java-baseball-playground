* 1~9의 숫자중 랜덤으로 3개의 숫자를 구한다
* 사용자로부터 입력 받는 3개 숫자 예외 처리
  * 1~9의 숫자인가?
  * 중복 값이 있는가?
  * 3자리인가?
* 위치와 숫자 값이 같은 경우 - 스트라이크
* 위치는 다른데 숫자 값이 같은 경우 - 볼
* 숫자 값이 다른 경우 - 낫싱
* 사용자가 입력한 값에 대한 실행 결과를 구한다

---
com / user(리스트-리스트)
123, 456 -> nothing
123, 235 -> 1ball
123, 145 -> 1strike

PlayResult result = Baseball.play(Arrays.asList(1,2,3), Arrays.asList(4,5,6)); 

---

com / user(리스트-ball)
123 / 1 4 -> nothing
123 / 1 2 -> ball
123 / 1 1 -> strike

--- 
작은 단위로 쪼개기(리스트-리스트 -> 하나의 ball-ball)
com / user
123, 456

1 4, 1 4 ->strike
1 4, 2 4 ->ball
1 4, 2 5 ->nothing

---
