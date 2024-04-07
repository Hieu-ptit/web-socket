package com.vpbank.common.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class UpdatePasswordRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
