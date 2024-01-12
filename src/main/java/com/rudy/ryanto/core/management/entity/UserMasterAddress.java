package com.rudy.ryanto.core.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "USER_MASTER_ADDRESS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "idmaster")
    private Long idMaster;
    @Column(name = "streetname")
    private String StreetName;
    @Column(name = "province")
    private String province;
    @Column(name = "national")
    private String national;
    @Column(name = "postalcode")
    private String postalCode;
}
