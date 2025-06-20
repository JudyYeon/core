package judy.core.common;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 로거 실행 테스트 컨트롤러
 */
@Controller // web 관련 의존성 gradle 추가했기 때문에 사용가능
@RequiredArgsConstructor // 기본 필수 생성자 -> @Autowired Bean 주입
public class LogDemoController {

    // Autowired 되어있으므로 생성된 Bean 주입하여 final 가능
    private final LogDemoService logDemoService;
    // ObjectProvider를 사용하여 (LookUp) DI 컨테이너에 스프링 Bean 생성요청을 지연 할 수 있도록 함
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){

        // 공통 처리가 가능한 인터셉터나 서블릿필터 활용하면 좋음
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerObjectProvider.getObject(); // 이때 미뤄둔 생성요청으로 Bean 주입

        myLogger.setRequestURL(requestURL);
        // 로깅 인스턴스 호출
        myLogger.log("controller test");
        // 비즈니스 계층 서비스 호출
        logDemoService.logic("testId");

        return "OK";
    }
}
