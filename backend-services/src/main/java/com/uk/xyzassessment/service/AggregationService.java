package com.uk.xyzassessment.service;

import com.uk.xyzassessment.client.PricingApiClient;
import com.uk.xyzassessment.client.ShipmentsApiClient;
import com.uk.xyzassessment.client.TrackApiClient;
import com.uk.xyzassessment.model.AggregationRequest;
import com.uk.xyzassessment.model.AggregationResponse;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class AggregationService {



    private final PricingApiClient pricingApiClient;


    private final TrackApiClient trackApiClient;


    private final ShipmentsApiClient shipmentsApiClient;

    public AggregationService(PricingApiClient pricingApiClient, TrackApiClient trackApiClient, ShipmentsApiClient shipmentsApiClient) {
        this.pricingApiClient = pricingApiClient;
        this.trackApiClient = trackApiClient;
        this.shipmentsApiClient = shipmentsApiClient;
    }


    public AggregationResponse aggregateData(AggregationRequest request) {

        AggregationResponse response = new AggregationResponse();

        CompletableFuture<Map<String, Double>> pricingFuture = pricingApiClient.getPricing(request.getPricing());
        CompletableFuture<Map<String, String>> trackFuture = trackApiClient.getTrack(request.getTrack());
        CompletableFuture<Map<String, List<String>>> shipmentsFuture = shipmentsApiClient.getShipments(request.getShipments());

        CompletableFuture.allOf(pricingFuture, trackFuture, shipmentsFuture).join();

        response.setPricing(pricingFuture.join());
        response.setTrack(trackFuture.join());
        response.setShipments(shipmentsFuture.join());

        return response;
    }
}
