package org.example.springjdbc.friendapp.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.springjdbc.friendapp.domain.Friend;
import org.example.springjdbc.friendapp.repository.FriendRepository;
import org.example.springjdbc.friendapp.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    //어떤 요청을 받지?
    //친구 추가 -- 보여주세요 (GET), 추가해주세요 (POST)
    @GetMapping("/add")
    public String addFriendForm() {
        return "friends/addform";
    }
    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend) {
        //서비스에게 이름과 이메일을 보내 친구정보를 저장해달라고 할것
        //서비스에 이름과 이메일을 담은 friend 객체를 전달할 것인지
        //name, email을 직접 전달할지!
        Friend saveFriend = friendService.addFriend(friend);
        System.out.println(saveFriend);
        return "redirect:/friends/add"; //임시로 저장하고 다시 친구추가풀 요청
    }


    @GetMapping("/list")
    public String listFriends(Model model) {
        Iterable<Friend> friends = friendService.getFriends();
        model.addAttribute("friends", friends);
        return "friends/list";
    }

    //친구 상세보기
    @GetMapping("/{id}")
    public String detailFriend(@PathVariable("id") Long id, Model model) {
        // 서비스에서 친구 하나 조회
        Friend friend = friendService.getFriendById(id);

        // 모델에 담아서 뷰로 전달
        model.addAttribute("friend", friend);

        // friends/detail.html 로 이동
        return "friends/detail";
    }

    //친구정보 수정 -> id에 해당하는 수정 풀을 보여달라
    @GetMapping("/edit/{id}")
    public String editFriend(@PathVariable("id") Long id, Model model) {
        Friend friend = friendService.getFriendById(id);
        model.addAttribute("friend", friend);
        return "friends/editform";
    }

    //수정해주세요
    @PostMapping("/edit")
    public String editFriend(@ModelAttribute Friend friend) {
        friendService.updateFriend(friend);
        return  "redirect:/friends/list";
    }

    //친구삭제
    @GetMapping("/delete/{id}")
    public String deleteFriend(@PathVariable("id") Long id) {
        friendService.getFriendById(id);
        return "redirect:/friends/list";
    }
    
    
    // url은 어떻게 사용하는게 좋을까
    //ex) http://localhost:8080/addFriend
    //ex) http://localhost:8080/updateFriend

    //ex) http://localhost:8080/friends/add
    //ex) http://localhost:8080/friends/update
}
