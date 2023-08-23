package com.rudy.ryanto.core.management.entity;

import com.rudy.ryanto.core.management.util.UserManagementConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "USER_MASTER_DATA")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterData {

    private Long id;

    private String userName;
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private UserManagementConstant.Status status;
}
