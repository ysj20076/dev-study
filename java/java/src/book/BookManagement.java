package book;

import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    // TODO: getter 메서드 구현

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n제목 : " + title
                + "\n저자 : " + author
                + "\n발행년도 : " + year
                + "\n가격 : " + price;
    }
}

public class BookManagement {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("자바의 정석", "남궁성", 2016, 30000),
                new Book("모던 자바", "케빈", 2021, 35000),
                new Book("클린 코드", "로버트", 2013, 25000),
                new Book("이펙티브 자바", "조슈아", 2018, 28000),
                new Book("자바 병렬 프로그래밍", "브라이언", 2022, 32000)
        );
        // TODO: 요구사항 구현
        //2020년 이후 출판된 도서만 필터링 00
        //가격이 20000원 이상인 도서 찾기
        //저자별로 도서를 그룹화
        //평균 가격 계산

        System.out.println("======2020년 이후 출판 도서======");
        List<Book> after2020 = books.stream()
                .filter(b -> b.getYear() >= 2020)
                .collect(Collectors.toList());
        after2020.forEach(System.out::println);

        System.out.println("\n======20000원 이상 도서======");
        books.stream()
                .filter(b -> b.getPrice() >= 20000)
                .forEach(System.out::println);

        System.out.println("\n======저자별로 도서 그룹화======");
        Map<String, List<Book>> byAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
        byAuthor.forEach((author, b) -> {
            System.out.println(author + " : " +
                    b.stream().map(Book::getTitle).collect(Collectors.toList()));
        });

        System.out.println("\n======평균가격======");
        //mapToInt, mapToDouble, mapToLong -> stream안의 객체를 기본형 스트림으로 바꿔줌
        //일반 스트림은 기본형을 래퍼클래스로 다룸
        //평균 같은 연산을 할때는 전용 기본형 스트림으로 변환할 수 있게 해줌!

        //average()의 리턴타입은 OptionalDouble -> 스트림이 비어있을 수도 있어서!
        //값이 없을수도 있을 때를 표현해줘야함
        // -> orElse() 
        double average = books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0); //스트림이 비어있으면 0.0 리턴
        System.out.println("책들의 평균가격 : " + average);

    }
}