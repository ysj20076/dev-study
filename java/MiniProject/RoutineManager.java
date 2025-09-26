package MiniProject;

import java.util.ArrayList;
import java.util.Scanner;

public class RoutineManager {
    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<RoutineContract> TODOlist = new ArrayList<>();
    //실행함수
    public void run() {
            while (true) {
                menu();
                String menu_num = sc.nextLine();
                if (menu_num.equals("1")) inputTODOlist();
                else if (menu_num.equals("2")) display();
                else if (menu_num.equals("3")) completeCheck();
                else if (menu_num.equals("4")) modify();
                else if (menu_num.equals("5")) delete();
                else if (menu_num.equals("6")) finishPercent();
                else if (menu_num.equals("7")) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    System.out.println("메뉴를 다시 선택해주세요.");
                }
            }
    }

    void menu() {
        System.out.println("\n==================================");
        System.out.println("        📌 하루 루틴 관리");
        System.out.println("==================================");
        System.out.println(" 1) 루틴 추가       2) 리스트 열람");
        System.out.println(" 3) 완료 체크       4) 이름 수정");
        System.out.println(" 5) 삭제            6) 전체 완료율");
        System.out.println(" 7) 종료");
        System.out.println("==================================");
        System.out.print("👉 선택 : ");
    }

    void inputTODOlist () {
        System.out.print("루틴 이름 : ");
        String name = sc.nextLine().trim();
        if(name.isEmpty()) {
            System.out.println("이름이 비어있습니다.");
            return;
        }
        TODOlist.add(new Routine(name));
        System.out.println("추가 되었습니다.");
    }

    void display () {
        if (TODOlist.isEmpty()) { //리스트 비었는지 확인
            System.out.println("❌ 등록된 루틴이 없습니다.");
            return;
        }

        System.out.println("\n--------- 📝 루틴 목록 ---------");
        for (int i = 0; i < TODOlist.size(); i++) {
            RoutineContract r = TODOlist.get(i);
            //삼항연산자 사용 - r.isDone()이 true면 [완료], false면 [미완]
            String mark = r.isDone() ? "✔" : "·";
            String state = r.isDone() ? "[완료]" : "[미완]";
            System.out.printf("%2d. %s %-6s %s\n", i + 1, mark, state, r.getName());
        }
        System.out.println("--------------------------------\n");

    }

    void completeCheck () {
        if (TODOlist.isEmpty()) { //리스트 비었는지 확인
            System.out.println("루틴이 없습니다.");
            return;
        }
        display();
        System.out.print("번호 : ");
        int choice = sc.nextInt() - 1;
        sc.nextLine(); //버퍼 개행(\n) 소비

        System.out.print("오늘 완료했습니까? (yes/no)");
        String answer = sc.nextLine().trim().toLowerCase();

        RoutineContract r = TODOlist.get(choice);
        if (answer.equals("yes")) {
            r.setDone(true);
        }
        else if (answer.equals("no")) {
            r.setDone(false);
        } else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    void modify () { //루틴 수정
        if (TODOlist.size() == 0) return;
        display(); //목록 출력
        System.out.print("번호 : ");
        int choice = sc.nextInt() - 1;
        sc.nextLine();

        System.out.print("새 이름 : ");
        TODOlist.get(choice).setName(sc.nextLine());
        System.out.println("수정 완료했습니다.");
    }

    void delete () { //루틴 제거
        if (TODOlist.size() == 0) {
            System.out.println("루틴이 없습니다.");
            return;
        }
        display(); //목록 출력
        System.out.print("번호 : ");
        int choice = sc.nextInt() - 1;
        sc.nextLine(); //개행소비
        TODOlist.remove(choice);
        System.out.println("삭제완료");

    }

    void finishPercent() {//전체완료율 표시
        if (TODOlist.size() == 0) {
            System.out.println("❌ 루틴이 없습니다.");
            return;
        }
        int total = TODOlist.size();
        int done = 0;

        for(RoutineContract r : TODOlist) {
            if(r.isDone()) done++;
        }
        double result = (done * 100.0) / total;

        System.out.println("\n--------------------------------");
        System.out.printf(" 📊 전체 완료율 : %.1f%%  (완료 %d / 총 %d)\n", result, done, total);
        System.out.println("--------------------------------\n");
    }


}
