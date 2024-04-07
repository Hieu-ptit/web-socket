package com.vpbank.common.model;

import com.dslplatform.json.CompiledJson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@CompiledJson
@Data
@Accessors(chain = true)
public class WofMAccount {
    private Long id;
    private String email;
    @JsonProperty("sub")
    private String address;
    private String jti;
    private Long iat;
    private Long exp;
    @JsonIgnore
    private String authorization;

}
