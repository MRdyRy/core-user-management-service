package com.rudy.ryanto.core.management.repository;

import com.rudy.ryanto.core.management.entity.UserMasterDetailData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailManagemenrRepository extends JpaRepository<UserMasterDetailData,Long> {
    public Optional<UserMasterDetailData> findByIdMaster(Long idMaster);
}
