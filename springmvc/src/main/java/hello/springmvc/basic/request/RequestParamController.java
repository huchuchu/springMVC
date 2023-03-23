package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void  requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}", username);
        log.info("age = {}", age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){
        log.info("userName = {}, memberAge = {}", memberName, memberAge);
        return "ok";
    }

    /**
     * @RequestParam 에서 Alias를 생략할 수 있다 (요청 파라미터 이름과 변수명을 동일하게 가져가야함)
     */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    /**
     * String, int, Integer 같은 단순타입일 경우
     * @RequestParam 을 생략할 수 있다 
     * (요청 파라미터 이름과 변수명을 동일하게 가져가야함)
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, // 파람으로 꼭 들어와야함 없으면 오류 발생
            @RequestParam(required = false) Integer age){   // 파람으로 안들어와도 오류발생 ㄴㄴ
                                                            // int age로 받을 경우 500에러발생 int는 기본형이기때문에 null을 받을 수 없기때문에!!
                                                            // 따라서 Integer로 형변환해줌!
        
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false , defaultValue = "-1") int age){

        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    /**
     * 파라미터를 Map으로 받기
     * multiValueMap으로도 파라미터 받을 수 있음
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    /**
     * @ModelAttribute : 객체로 파라미터 받아서 바인딩까지 해줌!
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username = {}, age = {}", helloData.getUsername(),helloData.getAge());
        log.info("helloData = {}", helloData);

        return "ok";
    }

    /**
     *  @ModelAttribute : 생략가능!
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2( HelloData helloData){
        log.info("username = {}, age = {}", helloData.getUsername(),helloData.getAge());
        log.info("helloData = {}", helloData);

        return "ok";
    }




}
