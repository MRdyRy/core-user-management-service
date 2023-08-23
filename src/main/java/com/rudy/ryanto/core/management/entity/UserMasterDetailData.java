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
    private Long id;

    private Long idMaster;
    @Enumerated(EnumType.ORDINAL)
    private UserManagementConstant.Sex sex;
    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date dob;
    private String placeOfBirth;
    private String idNumber;
    @Enumerated(EnumType.STRING)
    private UserManagementConstant.IdType idType;
    private UserManagementConstant.SIMType simType;
}
