package coo.lxt.island.server.icloud.fmf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FmfServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmfServerApplication.class, args);
    }
}
