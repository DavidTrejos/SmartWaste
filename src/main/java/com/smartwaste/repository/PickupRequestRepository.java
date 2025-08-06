package com.smartwaste.repository;

import com.smartwaste.model.PickupRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PickupRequestRepository extends JpaRepository <PickupRequest, Long> {


        List<PickupRequest> findByStatus(String status);

}
