package gradeprocessor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Student {
    private String name;
    private Map<String, Integer> scores;

    public Student(String name, Map<String, Integer> scores) {
        this.name = name;
        this.scores = scores;
    }
    // TODO: 필요한 메서드 구현
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }



}

public class GradeProcessor {
    public static void main(String[] args) {
        // TODO: 학생 데이터 생성 및 처리
        //평균 점수가 80점 이상인 학생 찾기
        //과목별 최고 점수 구하기
        //전체 학생의 평균 점수 계산
        //학생을 등급별로 분류 (A: 90이상, B: 80-89, C: 70-79, D: 70미만)
        List<Student> students = Arrays.asList(

        );
    }
}
