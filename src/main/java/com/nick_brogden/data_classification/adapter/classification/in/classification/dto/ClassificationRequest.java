package com.nick_brogden.data_classification.adapter.classification.in.classification.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record ClassificationRequest(
        @NotBlank(message = "Email is required.")
        @Email(message = "Email is invalid.")
        String email,
        @Size(min = 1, message = "At least 1 domain is required.")
        Set<String> domains
) {
}
