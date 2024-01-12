package com.rudy.ryanto.core.management.entity;

import com.rudy.ryanto.core.management.util.UserManagementConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "USER_MASTER_DATA")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private UserManagementConstant.Status status;
}
