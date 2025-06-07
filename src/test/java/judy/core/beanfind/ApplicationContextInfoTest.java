package judy.core.beanfind;

import judy.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Junit5 부터는 public 설정안해도됨
public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("모든 빈 출력하기")
    void findALlBean(){
        // Junit5 부터는 public 설정안해도됨
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // 단축키 itar 하면 for문, iter 하면 for-each 문
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("[name] = " + beanDefinitionName + " [object] = " + bean); // 단축키 soutv 하면 자동완성, soutm 메서드명 찍어줌

            // org.springframework.context 하위에 나오는건 스프링 자체에서 관리하는 bean
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        // Junit5 부터는 public 설정안해도됨
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // 단축키 itar 하면 for문, iter 하면 for-each 문
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // BeanDefinition.ROLE_APPLICATION : 직접등록한 애플리케이션 빈
            // BeanDefinition.ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("[name] = " + beanDefinitionName + " [object] = " + bean); // 단축키 soutv 하면 자동완성, soutm 메서드명 찍어줌
            }

        }
    }
            
}
