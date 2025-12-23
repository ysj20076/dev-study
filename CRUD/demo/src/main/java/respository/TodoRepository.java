package respository;

import entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//Todo라는 엔티티를 id타입이 long인것으로 관리
//todo 엔티티를 저장하고 그 todo id 타입은 long이다
public interface TodoRepository extends JpaRepository<Todo, Long> {
    //save(), findAll(), findById(), deleteById() 다 있음
}
