package com.smartwaste.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PickupRequestDTO {

    @NotBlank(message = "Waste type is required")
    private String wasteType;

    @NotBlank(message = "Location is required")
    private String location;

    private String notes;
}
