package coo.lxt.island.server.icloud.fmf.feign.fallback;

import coo.lxt.island.common.icloud.vo.ICloudSessionVO;
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
        return authVO -> new ICloudSessionVO();
    }
}
