package com.uk.xyzassessment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

// ShipmentsApiClient.java
@FeignClient(name = "shipments-api", url = "${shipments.api.url}")
public interface ShipmentsApiClient {
    @GetMapping("/shipments")
    CompletableFuture<Map<String, List<String>>> getShipments(@RequestParam("q") List<String> orderNumbers);
}
