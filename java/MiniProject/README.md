# 하루 루틴 관리 프로그램


Java 기초 문법과 OOP 개념(추상클래스, 인터페이스, 다형성)을 복습하기 위해 만든 콘솔 기반 미니 프로젝트입니다.  
루틴을 추가, 조회, 완료 체크, 수정, 삭제할 수 있으며 전체 완료율도 계산하는 프로그램입니다.





---





## 📂 프로젝트 구조
```
MiniProject/
├─ RoutineContract.java # 루틴 규약 정의 (인터페이스)
├─ AbstractRoutine.java # 공통 속성/메서드 구현 (추상클래스)
├─ Routine.java # 실제 루틴 클래스
├─ RoutineManager.java # 메뉴/기능 관리
└─ RoutineTest.java # 실행 진입점 (main)
```




---





## 핵심 코드

### 1) 인터페이스 (RoutineContract.java)
```java
public interface RoutineContract {
    String getName();
    void setName(String name);
    boolean isDone();
    void setDone(boolean done);
}
```
루틴 이름과 완료 여부가 있는 공통 규약을 설정했습니다.





### 2) 추상클래스 (AbstractRoutine.java)
```java
public abstract class AbstractRoutine implements RoutineContract {
    private String name; //루틴 이름
    private boolean done;

    public AbstractRoutine(String name) {
        this.name = name;
        this.done = false;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean isDone() {
        return done;
    }
    @Override
    public void setDone(boolean done) {
        this.done = done;
    }
}
```
공통 속성과 메서드는 추상클래스에 모아두고, 루틴 클래스가 상속받아 구현하도록 했습니다.





### 2) 루틴 출력 메서드 (RoutineManager.java)
```java
void display() {
    if (TODOlist.isEmpty()) {
        System.out.println("❌ 루틴이 없습니다.");
        return;
    }
    for (int i = 0; i < TODOlist.size(); i++) {
        RoutineContract r = TODOlist.get(i);
        String mark = r.isDone() ? "✔" : "·"; //삼항 연산자 사용
        String state = r.isDone() ? "[완료]" : "[미완]";
        System.out.printf("%2d. %s %-6s %s\n", i + 1, mark, state, r.getName());
    }
}
```
루틴 리스트를 가독성 있게 출력하는 기능입니다.





---




### (Plus) 루틴입력 유효성검사
```java
void inputTODOlist() {
        String ToDolist;
        while (true) {
            System.out.print("루틴: ");
            String name = sc.nextLine().trim();

            // 단어 유효성 검사 (알파벳만 허용, 빈 문자열 불가)
            if (name.matches("[a-zA-Z]+")) {
                TODOlist.add(new Routine(name));
                break; // 올바른 입력 → 반복 종료
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력하세요!");
            }
        }
    }
```
영문자만 허용하고 공백이나 숫자 같은 잘못된 입력은 거부하도록 만들었습니다.

---



## 콘솔 출력
```
==================================
        📌 하루 루틴 관리
==================================
 1) 루틴 추가       2) 리스트 열람
 3) 완료 체크       4) 이름 수정
 5) 삭제            6) 전체 완료율
 7) 종료
==================================
👉 선택 : 1
루틴 이름 : 아침 러닝
추가 되었습니다.

👉 선택 : 2
--------- 📝 루틴 목록 ---------
 1. · [미완] 아침 러닝
--------------------------------

👉 선택 : 3
번호 : 1
오늘 완료했습니까? (yes/no)yes

👉 선택 : 2
--------- 📝 루틴 목록 ---------
 1. ✔ [완료] 아침 러닝
--------------------------------

👉 선택 : 6
--------------------------------
 📊 전체 완료율 : 100.0%  (완료 1 / 총 1)
--------------------------------

👉 선택 : 7
종료합니다.

```

---
### 느낀 점
* 이번 루틴 관리 프로그램을 구현하면서 단순히 자바 문법을 익히는 것을 넘어, 실제로 동작하는 작은 프로그램을 만드는 경험을 할 수 있었습니다.
<br>

1. 객체지향 설계의 필요성을 체감할 수 있었습니다. 루틴이라는 개념을 Routine 클래스로 추상화하고, 이를 관리하는 RoutineManager 클래스를 따로 두면서 프로그램의 구조가 훨씬 명확해졌습니다.
<br>

2. 사용자 입장에서 생각하게 되었습니다. 메뉴를 보기 좋게 꾸미고, 입력값이 잘못되었을 때 if문으로 예외 처리를 추가하면서 "사용하기 편한 프로그램"을 고민하는 과정이 있었습니다. 특히 완료율을 퍼센트로 계산해서 보여주는 기능은 작은 아이디어였지만, 프로그램의 완성도를 높여준 것 같습니다.
<br>

3. 이 과정을 통해 개발의 어려움과 재미를 동시에 느꼈습니다. 팀원과 함께 문제를 해결하고 나니 이해와 성취가 깊어졌고, 그 과정이 점차 실력을 키워준다는 걸 알게 되었습니다.
