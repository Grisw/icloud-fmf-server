package coo.lxt.island.server.icloud.fmf.feign.fallback;

import coo.lxt.island.common.icloud.vo.ICloudAuthWithTokenVO;
import coo.lxt.island.common.icloud.vo.ICloudHSA2VO;
import coo.lxt.island.common.icloud.vo.ICloudLoginVO;
import coo.lxt.island.common.icloud.vo.ICloudTrustSessionVO;
import coo.lxt.island.server.icloud.fmf.feign.IICloudService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ICloudServiceFallbackFactory implements FallbackFactory<IICloudService> {

    @Override
    public IICloudService create(Throwable throwable) {
        log.error("Hystrix fallback.", throwable);
        return new IICloudService() {
            @Override
            public LoginStatus login(ICloudLoginVO authVO) throws Exception {
                return LoginStatus.TRY_LATER;
            }

            @Override
            public boolean verifyHSA2(ICloudHSA2VO hsa2VO) throws Exception {
                return false;
            }

            @Override
            public boolean authWithToken(ICloudAuthWithTokenVO authWithTokenVO) throws Exception {
                return false;
            }

            @Override
            public boolean trustSession(ICloudTrustSessionVO trustSessionVO) throws Exception {
                return false;
            }
        };
    }
}
