package com.smartwaste.controller;

import com.smartwaste.dto.PickupRequestDTO;
import com.smartwaste.dto.PickupResponseDTO;
import com.smartwaste.model.PickupRequest;
import com.smartwaste.service.PickupRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pickups")
public class PickupRequestController {

    @Autowired
    private PickupRequestService service;

    @PostMapping
    public ResponseEntity<PickupResponseDTO> createPickup(@RequestBody PickupRequestDTO dto) {
        PickupResponseDTO response = service.create(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PickupResponseDTO>> getAllPickups(){
        List<PickupResponseDTO> pickups = service.findAll();
        return ResponseEntity.ok(pickups);
    }

    @GetMapping("/status")
    public ResponseEntity<List<PickupResponseDTO>> getByStatus(@RequestParam String status){
        List<PickupRequest> requests = service.findByStatus(status);
        List<PickupResponseDTO> result = requests.stream()
                .map(service::mapToResponseDTO)
                .toList();
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PickupResponseDTO> updateById(@PathVariable Long id,@RequestBody PickupRequestDTO dto ){
        Optional <PickupRequest> updated = service.updateRequest(id,dto);

        return updated
                .map(entity -> ResponseEntity.ok(service.mapToResponseDTO(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
