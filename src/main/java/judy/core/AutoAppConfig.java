package judy.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component 이 붙은 클래스를 모두 스캔해서 자동으로 bean 으로 등록
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // @Configuration 에 이미 @Component 되어있어서 제외시켜준다(충돌방지) 예제에서만 이렇게 씀
)
public class AutoAppConfig {
}
