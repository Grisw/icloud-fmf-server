package coo.lxt.island.server.icloud.fmf.feign;

import coo.lxt.island.common.icloud.api.IICloudApi;
import coo.lxt.island.server.icloud.fmf.feign.fallback.ICloudServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "icloud-server", path = "/icloud", fallbackFactory = ICloudServiceFallbackFactory.class)
public interface IICloudService extends IICloudApi { }
