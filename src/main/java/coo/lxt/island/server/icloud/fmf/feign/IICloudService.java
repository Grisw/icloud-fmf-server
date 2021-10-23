package coo.lxt.island.server.icloud.fmf.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("icloud-server")
@RequestMapping("/icloud")
public interface IICloudService {

    @GetMapping("/hello")
    String getHello(@RequestParam("name") String name);
}
