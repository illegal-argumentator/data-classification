package com.nick_brogden.data_classification.adapter.classification.in.classification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ClassificationRequest(
        @NotBlank(message = "Email is required.")
        String email,
        @Size(min = 1, message = "At least 1 domain is required.")
        List<String> domains
) {
}
