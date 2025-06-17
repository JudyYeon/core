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
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){

        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
