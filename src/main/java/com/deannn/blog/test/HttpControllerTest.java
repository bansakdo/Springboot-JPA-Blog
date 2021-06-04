package com.deannn.blog.test;


import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = Member.builder().username("deannn").password("123").email("deannn@test.com").build();
        System.out.println(TAG + "getter : " + m.getId());
        m.setId(5000);
        System.out.println(TAG + "setter : " + m.getId());
        System.out.println(TAG + "getter : " + m.getUsername());
        m.setUsername("park");
        System.out.println(TAG + "setter : " + m.getUsername());
        return "lombok test finished";
    }

    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get 요청:  " + m.getId() + ", " + m.getUsername();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
        return "post 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest() {
        return "put 요청";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }

}
