import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentApplication {
    public static void main(String[] args) {
        SpringBootApplication.run(NacosPaymentApplication.class);
    }
}
