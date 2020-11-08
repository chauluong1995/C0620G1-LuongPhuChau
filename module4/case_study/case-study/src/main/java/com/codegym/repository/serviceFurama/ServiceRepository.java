package com.codegym.repository.serviceFurama;

import com.codegym.entity.serviceFurama.ServiceFurama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceFurama, String> {
}
