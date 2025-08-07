package com.smartwaste.service;


import com.smartwaste.dto.PickupRequestDTO;
import com.smartwaste.dto.PickupResponseDTO;
import com.smartwaste.model.PickupRequest;
import com.smartwaste.repository.PickupRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickupRequestService {

    @Autowired
    private PickupRequestRepository repository;

    public PickupResponseDTO create(PickupRequestDTO dto){
        PickupRequest request = new PickupRequest();

        request.setWasteType(dto.getWasteType());
        request.setLocation(dto.getLocation());
        request.setNotes(dto.getNotes());

        PickupRequest saved = repository.save(request);
        return mapToResponseDTO(saved);
    }

    public List<PickupResponseDTO> findAll(){
        return repository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }


    public PickupResponseDTO mapToResponseDTO(PickupRequest request) {
        return new PickupResponseDTO(
                request.getId(),
                request.getWasteType(),
                request.getLocation(),
                request.getNotes(),
                request.getStatus(),
                request.getRequestedAt()
        );
    }

    public List <PickupRequest> findByStatus(String status){
        return repository.findByStatus(status);
    }

    public Optional<PickupRequest> updateRequest (Long id, PickupRequestDTO dto){

        Optional<PickupRequest> optional = repository.findById(id);

        if(optional.isPresent()){
            PickupRequest request = optional.get();
            request.setWasteType(dto.getWasteType());
            request.setLocation(dto.getLocation());
            request.setNotes(dto.getNotes());
            request.setStatus(dto.getStatus());

            PickupRequest updated = repository.save(request);
            return Optional.of(updated);
        }

        return Optional.empty();
    }



}
