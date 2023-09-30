package com.tedy.Banking.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tedy.Banking.Domain.Value;
//contains data from API
@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote(String type, Value value) {
}
