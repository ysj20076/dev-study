package controller;


import entity.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import respository.TodoRepository;
import service.TodoService;

import java.util.List;

//http 요청받기, 응답 돌려주기
@RestController
public class TodoController {
    private final TodoService todoService;

    //의존성 주입
    //TodoController는 TodoService없이는 동작이 되지 않으므로
    //생성될때 반드시 TodoService 주입받음
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    //http 요청으로 전달된 todo 데이터를 todoService에 저장
    @PostMapping("/todos")
    public Todo create(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    //저장된 모든 todo를 조회하여 응답으로 반환
    @GetMapping("/todos")
    public List<Todo> list() {
        return todoService.findAll();
    }


}
