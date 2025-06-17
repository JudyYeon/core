package judy.core.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * < MyLogger의 멤버변수를 비즈니스 계층에서 사용하기 위한 서비스>
 * request scope의 MyLogger 덕분에 필요한 것들을 전부 파라미터로 넘기지 않고, MyLogger의 멤버변수에 저장해서
 * 코드와 계층을 깔끔하게 유지함.
 *
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;


    public void logic(String id) {

        myLogger.log("service id = " + id);
    }
}
