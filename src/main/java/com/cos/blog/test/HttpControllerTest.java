package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;

//사용자 요청 -> 응답(HTML 파일)
//@Controller

//사용자 요청 -> 응답(Data) 
@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest:";
	
	//http://localhost:8080/http/lombok --> http://localhost:8000/blog/http/lombok 
	@GetMapping("http/lombok")
	public String lombokTest() {
		//lombok의 @Builder 패턴을 사용하면 객체생성시 생성자의 순서에 상관없이 생성할 수 있음.
		// -->  Builder 패턴을 직접 만들지 않아도 된다.
		Member m = Member.builder().username("ssar").password("1111").email("gsh3578@naver.com").build();
		System.out.println(TAG+"gette : "+m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"sette : "+m.getUsername());
		return "lombok test 완료";
	}
	
	//인터넷브라우저 요청은 무조건 get요청밖에 할 수 없다.
	//http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m ) {//MessageConvert(스프링부트) : Member객체로 파싱함.
		return "get 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	} 
	
	//http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {//MessageConvert(스프링부트) : 응답(JSON)->Member객체로 파싱함.
		return "post 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();	
	} 
	
	//http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	} 
	
	//http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	} 
}
