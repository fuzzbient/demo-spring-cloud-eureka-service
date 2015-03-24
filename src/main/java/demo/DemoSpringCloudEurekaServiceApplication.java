package demo;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DemoSpringCloudEurekaServiceApplication {
	private Log logger = LogFactory.getLog(getClass());

	@RequestMapping("/")
	public Map<String,String> hello() {
		if (logger.isDebugEnabled()) {
			logger.debug("DemoSpringCloudEurekaServiceApplication.hello()");
		}
		Map<String,String> result = new HashMap<String,String>();
		String pid = ManagementFactory.getRuntimeMXBean().getName();
		result.put("pid", pid);
		result.put("message", "Hello world from Eureka Service Demo Endpoint PID[" + pid + "]");
		//if (true) throw new RuntimeException("foo");
		return result;
	}
	
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudEurekaServiceApplication.class, args);
    }
}
