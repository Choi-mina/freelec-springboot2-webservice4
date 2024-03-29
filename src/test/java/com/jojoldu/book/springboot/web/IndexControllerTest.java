package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    /**
     * MockMvc와 TestRestTemplate 차이
     * MockMvc : 컨테이너를 실행X, 서버의 입장에서 구현한 API를 통해 비지니스 로직에 문제가 없는지 테스트
     * TestRestTemplate : 컨테이너를 직접 실행, 클라이언트 입장에서 사용할 때 문제가 없는지 테스트
     * */
    @Autowired
    private TestRestTemplate restTemplate;  // Spring Boot에서 컨트롤러를 테스트하기 위해 사용

    @Test
    public void 메인페이지로_로딩(){
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
