package com.uk.xyzassessment.controller;

import com.uk.xyzassessment.model.AggregationRequest;
import com.uk.xyzassessment.model.AggregationResponse;
import com.uk.xyzassessment.service.AggregationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aggregation")
public class AggregationController {

    private AggregationService aggregationService;

    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @PostMapping
    public ResponseEntity<AggregationResponse> aggregateData(@RequestBody AggregationRequest request) {
        AggregationResponse response = aggregationService.aggregateData(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?>getMessage(){
        var message = "API aggregation service - up";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
