package com.uk.xyzassessment.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AggregationRequest implements Serializable {

    private List<String> pricing;
    private List<String> track;
    private List<String> shipments;

}
