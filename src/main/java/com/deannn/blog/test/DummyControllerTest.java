package com.deannn.blog.test;

import com.deannn.blog.model.RoleType;
import com.deannn.blog.model.User;
import com.deannn.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired  // 의존성 주입(DI)
    private UserRepository userRepository;

//    해당 페이지를 요청할 때 body에 username, password, email과 같은 이름의 데이터를 가지고 요청하면
//    메서드 파라미터에 자동으로 매핑된다. mime type이 x-www-form-urlencoded인 경우.
    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("id: " + user.getId());
        System.out.println("username :" + user.getUsername());
        System.out.println("password :" + user.getPassword());
        System.out.println("email :" + user.getEmail());
        System.out.println("role :" + user.getRole());
        System.out.println("createDate :" + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

}

