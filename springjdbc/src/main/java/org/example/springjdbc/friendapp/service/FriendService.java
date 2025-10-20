package org.example.springjdbc.friendapp.service;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.friendapp.domain.Friend;
import org.example.springjdbc.friendapp.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {
    //서비스와 레파지토리의 구분이 모호하다?
    //레파지토리는 db에 crud 만
    //-> 비즈니스 로직을 레포가 가지면 안됨
    //회원가입 - 14세 이상만 회원으로 받겠다 : 서비스에서!
    //서비스 - 회원가입해줘()
    //레포 - 회원정보 저장해줘()
    //실제 좀더 복잡한 어플리케이션에서는 가장 중요한 부분이 서비스
    //@Autowired
    private final FriendRepository friendRepository;
    //친구를 추가해주세요
    public Friend addFriend(Friend friend) {
        //친구를 추가하기 위해서 조건이 있다면? 여기서 실행한 수 조건을 만족하면 db저장
        //아니면 친구추가 x
        return friendRepository.save(friend); //save가 실행되고 리턴되는 객체는 id값이 채워져있음
    }

    //친구 리스트 보여주세요
    public Iterable<Friend> getFriends() {
        return friendRepository.findAll();
    }
    
    //친구정보 상세조회
    public Friend getFriendById(Long id) {
        return friendRepository.findById(id).orElseThrow();
    }

    //친구정보수정
    public Friend updateFriend(Friend friend) {
        //save() 메서드는 엔티티에 id로 지정한 필드의 값이 존재하면,
        //update 쿼리를 생성
        //id 필드가 null이라면 insert 쿼리 생성
        return friendRepository.save(friend);
    }
    
    //친구삭제
    public void deleteFriendById(Long id) {
        friendRepository.deleteById(id);
    }
}




