package com.uk.xyzassessment.client;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "pricing-api", url = "${pricing.api.url}")
public interface PricingApiClient{


    @GetMapping("/pricing")
    CompletableFuture<Map<String, Double>> getPricing(@RequestParam("q") List<String> codes);
}


