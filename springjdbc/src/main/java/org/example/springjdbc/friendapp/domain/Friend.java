package org.example.springjdbc.friendapp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Table 생략가능 -> db와 클래스 이름이 같으면
public class Friend {
    @Id
    private Long id;
    private String name;
    private String email;

}
