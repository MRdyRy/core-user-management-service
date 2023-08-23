package com.rudy.ryanto.core.management.repository;

import com.rudy.ryanto.core.management.entity.UserMasterAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserMasterAddress,Long> {

    public Optional<UserMasterAddress> findByIdMaster(Long idMaster);
}
