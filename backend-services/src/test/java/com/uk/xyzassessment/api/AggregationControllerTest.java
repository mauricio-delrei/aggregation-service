package com.uk.xyzassessment.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.uk.xyzassessment.controller.AggregationController;
import com.uk.xyzassessment.model.AggregationRequest;
import com.uk.xyzassessment.model.AggregationResponse;
import com.uk.xyzassessment.service.AggregationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
@WebMvcTest(AggregationController.class)
public class AggregationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AggregationService aggregationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAggregateData() throws Exception {
        // Create an AggregationRequest object
        AggregationRequest request = new AggregationRequest(/* set your values here */);

        // Create a mock AggregationResponse (replace with your actual response)
        AggregationResponse expectedResponse = new AggregationResponse(/* set your values here */);

        // Mock the behavior of the aggregationService
        when(aggregationService.aggregateData(any(AggregationRequest.class)))
                .thenReturn(expectedResponse);

        // Perform the POST request with the AggregationRequest JSON
        mockMvc.perform(MockMvcRequestBuilders.post("/aggregation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
