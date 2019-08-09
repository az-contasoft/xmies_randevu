package az.contasoft.xmies_randevu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("az.contasoft.xmies_randevu")
public class XmiesRandevuApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmiesRandevuApplication.class, args);
    }

}
