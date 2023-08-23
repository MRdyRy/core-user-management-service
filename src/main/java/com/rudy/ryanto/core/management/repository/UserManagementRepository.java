package com.rudy.ryanto.core.management.repository;

import com.rudy.ryanto.core.management.entity.UserMasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementRepository extends JpaRepository<UserMasterData,Long> {
}
