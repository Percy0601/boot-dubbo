package boot.dubbo.api;

import javax.ws.rs.Path;

import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol = {"rest"}, group = "annotationConfig", validation = "true")
@Path("demo")
public interface DemoService {
	/**
	 * 基本测试
	 * 
	 * @param name
	 * @return
	 */
	String sayHello(String name);

}
