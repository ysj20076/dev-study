package service;

import entity.Todo;
import org.springframework.stereotype.Service;
import respository.TodoRepository;

import java.util.List;

//비즈니스 로직
//이 기능이 어떻게 동작해야 하는지를 담는다
@Service
public class TodoService {
    //db 접근해야하기때문에
    private final TodoRepository todoRepository;

    //초기화라기 보다는 의존성 주입
    //TodoService는 TodoRepository 없이는 동작할수 없기 때문에
    //TodoService가 생성될때 반드시 레포를 주입받는다.
    //이유 : 의존성을 명확하게 하기위해
    //      테스트 할수있게? 더 알아봐야 함
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //todo를 db에 저장해야함
    public Todo save(Todo todo) {
        return todoRepository.save(todo); //인터페이스에 있는 저장함수 사용
    }

    //todo를 db에서 검색할수 있어야함
    public List<Todo> findAll() {
        //List형태로 엔티티가 반환됨
        return todoRepository.findAll();
    }



}
