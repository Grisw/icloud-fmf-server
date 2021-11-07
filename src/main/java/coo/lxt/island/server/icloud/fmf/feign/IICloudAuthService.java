package coo.lxt.island.server.icloud.fmf.feign;

import coo.lxt.island.common.icloud.api.IICloudAuthApi;
import coo.lxt.island.server.icloud.fmf.feign.fallback.ICloudServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "icloud-server", path = "/icloud/auth", fallbackFactory = ICloudServiceFallbackFactory.class)
public interface IICloudAuthService extends IICloudAuthApi { }
