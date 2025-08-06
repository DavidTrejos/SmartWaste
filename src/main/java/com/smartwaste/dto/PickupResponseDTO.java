package com.smartwaste.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PickupResponseDTO {
    private Long id;
    private String wasteType;
    private String location;
    private String notes;
    private String status;
    private LocalDateTime requestedAt;
}
