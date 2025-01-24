package com.zikan.order_service.domain.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Customer (
        @NotBlank(message = "Customer name is required" )
        String name,

        @NotBlank (message = "Customer email is required")
        @Email
        String email,

        @NotBlank (message = "Customer Phone Number is required")
        String phone

) {


}
