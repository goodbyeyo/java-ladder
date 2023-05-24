
### 사다리 게임

---

### Step1. Stream, Lambda Practice
`Lambda`
 - [X] 익명 클래스를 람다로 전환
 - [X] 람다를 활용해 숫자 연산 중복 제거

`Stream`
 - [X] List 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구하기
   - [X] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass
 - [X] printLongestWordTop100() 메서드를 구현
   - [X] 단어의 길이가 12자를 초과하는 단어를 추출한다.
   - [X] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
   - [X] 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
   - [X] 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해

`Optional`
 - [X] Optional 활용 조건에 따른 반환
   - [X] UserTest 단위 테스트 통과하도록 구현 
 - [X] Optional 값 반환
   - [X] UsersTest 단위 테스트가 통과하도록 구현
 - [X] Optional Exception 처리
   - [X] ExpressionTest 단위테스트 통과하도록 구현

---

### Step2. 사다리(생성)
`요구사항 및 구현 TODO 리스트 `
- [X] 입력 UI
   - [X] 사다리 게임 참여 사람 이름 입력 UI (최대5글자)
   - [X] 최대 사다리 높이 입력 UI
- [X] 실행 결과 출력
   - [X] 참여자 이름 출력(쉼표 기준 구분)
   - [X] 사다리 출력
   - [X] 사다리 폭은 사람이름 5글자 고려
   - [X] 사다리 세로는 이름의 중앙에 위치하도록 구현
- [X] 도메인 기능
   - [X] 입력 UI 에서 전달한 사람이름 문자열 분리(쉼표로 구분)
   - [X] 참여자들의 이름 상태를 가지는 객체 구현
     - [X] 유효한 이름 문자열 구분자 포함 여부 확인 
     - [X] 참여자 수와 사다리의 가로 넓이가 같은지 확인 
   - [X] 이름 객체 구현
     - [X] 이름 길이 유효성검증 : 5글자 제한
   - [X] 사다리의 한줄의 상태를 가지는 라인 객체 구현
     - [X] 사다리의 수평선의 유무는 boolean 으로 표현
     - [X] 사다리의 넓이는 양수일것
   - [X] 여러줄의 상태를 가지는 사다리 객체 구현
     - [X] 일급컬렉션으로 구현
     - [X] 사다리의 높이는 양수일것
     - [X] 사다리의 넓이와 참가자수는 같은지 확인
   - [X] 사다리 수평선 생성 전략
     - [X] 랜덤 전략
       - [X] 사다리의 첫번째 수평선은 랜덤하게 생성
       - [X] 연속해서 수평선이 생성되지 않는 규칙
       - [X] 이전 수평선이 없는 경우는 랜덤 생성
     - [X] 고정 전략
       - [X] 테스트를 위한 고정 생성 전략
   - [X] 사다리 게임 객체
     - [X] 참여자와 사다리의 상태를 가지는 사다리 게임 객체
     - [X] 사다리가 올바르게 생성되었는지 확인
       - [X] 사다리의 넓이와 참여인원수는 같아야 한다
---

### Step3. 사다리(게임 실행)
- `입력 UI 추가` 
  - [ ] 사다리 당첨 상품 입력 UI 추가 (당첨 내용은 쉼표 구분)
  - [ ] 결과를 보고 싶은 사람 입력 UI 추가

- `실행 결과 출력(UI) 추가`   
  - [ ] 개인별 이름을 입력하면 개인별 결과를 출력
    - [ ] 개인별 이름 결과 출력 후 개인별 이름 입력 UI 재입력 가능
  - [ ] "all"을 입력하면 전체 참여자의 실행 결과를 출력 
    - [ ] 전체 참여자 결과 출력 후 실행 종료
  
- `도메인 기능`
  - [ ] 당첨 상품 객체 : Prize
    - [ ] 참여자와 1:1 맵핑
  - [ ] 당첨 상품 일급 컬렉션 : Prizes
    - [ ] 입력 값 콤마로 구분하여 저장
  - [ ] 기능 추가
    - [ ] 특정 인덱스(참여자 한명) 당첨자 계산
    - [ ] 전체 인덱스(참여자 전체) 당첨자 계산