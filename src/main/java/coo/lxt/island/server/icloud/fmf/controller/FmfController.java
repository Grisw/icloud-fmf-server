package coo.lxt.island.server.icloud.fmf.controller;

import coo.lxt.island.common.exception.ValidateException;
import coo.lxt.island.common.icloud.api.IICloudApi;
import coo.lxt.island.common.icloud.vo.ICloudAuthWithTokenVO;
import coo.lxt.island.common.icloud.vo.ICloudHSA2VO;
import coo.lxt.island.common.icloud.vo.ICloudLoginVO;
import coo.lxt.island.common.icloud.vo.ICloudTrustSessionVO;
import coo.lxt.island.server.icloud.fmf.feign.IICloudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fmf")
@Slf4j
public class FmfController {

    @Autowired
    private IICloudService iCloudService;

    @GetMapping("/login")
    @ResponseBody
    public IICloudApi.LoginStatus login(@RequestParam String accountName, @RequestParam String password) throws Exception {
        try {
            return iCloudService.login(new ICloudLoginVO(accountName, password));
        } catch (ValidateException e) {
            log.error("ILLegal!!", e);
            throw e;
        }
    }

    @GetMapping("/verify/hsa2")
    @ResponseBody
    public boolean verifyHSA2(@RequestParam String accountName, @RequestParam String securityCode) throws Exception {
        try {
            return iCloudService.verifyHSA2(new ICloudHSA2VO(accountName, securityCode));
        } catch (ValidateException e) {
            log.error("ILLegal!!", e);
            throw e;
        }
    }

    @GetMapping("/trust")
    @ResponseBody
    public boolean trustSession(@RequestParam String accountName) throws Exception {
        try {
            return iCloudService.trustSession(new ICloudTrustSessionVO(accountName));
        } catch (ValidateException e) {
            log.error("ILLegal!!", e);
            throw e;
        }
    }

    @GetMapping("/auth")
    @ResponseBody
    public boolean authWithToken(@RequestParam String accountName) throws Exception {
        try {
            return iCloudService.authWithToken(new ICloudAuthWithTokenVO(accountName));
        } catch (ValidateException e) {
            log.error("ILLegal!!", e);
            throw e;
        }
    }

}
