package coo.lxt.island.server.icloud.fmf.controller;

import coo.lxt.island.server.icloud.fmf.feign.IICloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fmf")
public class FmfController {

    @Autowired
    private IICloudService iCloudService;

    @GetMapping("/hello")
    public String hello() {
        return iCloudService.getHello("Alimama");
    }

}
