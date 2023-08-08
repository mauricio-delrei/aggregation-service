package com.uk.xyzassessment.service;


import com.uk.xyzassessment.client.PricingApiClient;
import com.uk.xyzassessment.client.ShipmentsApiClient;
import com.uk.xyzassessment.client.TrackApiClient;
import com.uk.xyzassessment.model.AggregationRequest;
import com.uk.xyzassessment.model.AggregationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AggregationServiceTest {
    @Mock
    private PricingApiClient pricingApiClient;

    @Mock
    private TrackApiClient trackApiClient;

    @Mock
    private ShipmentsApiClient shipmentsApiClient;

    private AggregationService aggregationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        aggregationService = new AggregationService(pricingApiClient, trackApiClient, shipmentsApiClient);
    }

    @Test
    void testAggregateData() throws ExecutionException, InterruptedException {
        AggregationRequest request = new AggregationRequest();
        request.setPricing(Collections.singletonList("NL"));
        request.setTrack(Collections.singletonList("NL"));
        request.setShipments(Collections.singletonList("NL"));

        Map<String, Double> pricingMap = new HashMap<>();
        pricingMap.put("NL", 10.0);
        CompletableFuture<Map<String, Double>> pricingFuture = CompletableFuture.completedFuture(pricingMap);
        when(pricingApiClient.getPricing(Collections.singletonList("NL"))).thenReturn(pricingFuture);

        Map<String, String> trackMap = new HashMap<>();
        trackMap.put("NL", "In transit");
        CompletableFuture<Map<String, String>> trackFuture = CompletableFuture.completedFuture(trackMap);
        when(trackApiClient.getTrack(Collections.singletonList("NL"))).thenReturn(trackFuture);

        Map<String, List<String>> shipmentsMap = new HashMap<>();
        shipmentsMap.put("NL", Collections.singletonList("Shipment1"));
        CompletableFuture<Map<String, List<String>>> shipmentsFuture = CompletableFuture.completedFuture(shipmentsMap);
        when(shipmentsApiClient.getShipments(Collections.singletonList("NL"))).thenReturn(shipmentsFuture);

        AggregationResponse response = aggregationService.aggregateData(request);

        assertEquals(pricingMap, response.getPricing());
        assertEquals(trackMap, response.getTrack());
        assertEquals(shipmentsMap, response.getShipments());
    }
}
