package com.uk.xyzassessment.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "track-api",url = "${track.api.url}")
public interface TrackApiClient {

    @GetMapping("/track")
    CompletableFuture<Map<String, String>> getTrack(@RequestParam("q") List<String> orderNumbers);

}
