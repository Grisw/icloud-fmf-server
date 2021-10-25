package coo.lxt.island.server.icloud.fmf.controller;

import coo.lxt.island.common.exception.ValidateException;
import coo.lxt.island.common.icloud.vo.ICloudAuthVO;
import coo.lxt.island.common.icloud.vo.ICloudSessionVO;
import coo.lxt.island.server.icloud.fmf.feign.IICloudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/fmf")
@Slf4j
public class FmfController {

    @Autowired
    private IICloudService iCloudService;

    @GetMapping("/hello")
    @ResponseBody
    public ICloudSessionVO hello(@RequestParam String accountName, @RequestParam(required = false) String password) throws IOException {
        try {
            return iCloudService.login(new ICloudAuthVO(accountName, password));
        } catch (ValidateException e) {
            log.error("ILLegal!!", e);
            throw e;
        }
    }

}
