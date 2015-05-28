package boot.dubbo.simple.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:META-INF/spring/applicationContext.xml")
public class DubboConfig {

}
