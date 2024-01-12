package com.rudy.ryanto.core.management.entity;

import com.rudy.ryanto.core.management.util.UserManagementConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "USER_MASTER_DETAIL_DATA")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterDetailData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "idmaster")
    private Long idMaster;
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private UserManagementConstant.Sex sex;
    @Column(name = "fullname")
    private String fullName;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "placeofbirth")
    private String placeOfBirth;
    @Column(name = "idnumber")
    private String idNumber;
    @Column(name = "idtype")
    @Enumerated(EnumType.STRING)
    private UserManagementConstant.IdType idType;
    @Enumerated(EnumType.STRING)
    @Column(name = "simtype")
    private UserManagementConstant.SIMType simType;
}
