
## 구현 기능

- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
- 게임 플레이어는 컴퓨터가 선택한 3개의 숫자를 입력한다. 
  - 숫자의 입력은 각각 1~9사이인 숫자 3개만 가능하다.
- 플레이어가 입력한 숫자에 대해 다음과 같은 결과를 출력한다.
  - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼
  - 같은 수가 전혀 없으면 낫싱
  - e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 순서에 맞게 모두 맞히면 게임이 종료된다.
- 게임이 종료된 후 게임을 재시작하거나 종료할 수 있다.
    - 재시작/종료를 선택하는 입력값은 1,2만 가능하다. (1은 재시작, 2는 종료)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
