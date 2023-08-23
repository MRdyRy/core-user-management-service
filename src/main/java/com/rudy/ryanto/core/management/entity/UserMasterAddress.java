package com.rudy.ryanto.core.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name = "USER_MASTER_ADDRESS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterAddress {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long idMaster;

    private String StreetName;
    private String province;
    private String national;
    private String postalCode;
}
