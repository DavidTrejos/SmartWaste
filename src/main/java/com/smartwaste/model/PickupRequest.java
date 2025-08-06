package com.smartwaste.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PickupRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wasteType;

    private String location;

    private String notes;

    private String status;

    private LocalDateTime requestedAt;


    @PrePersist
    public void setRequestedAt() {
        this.requestedAt = LocalDateTime.now();
    }
}
