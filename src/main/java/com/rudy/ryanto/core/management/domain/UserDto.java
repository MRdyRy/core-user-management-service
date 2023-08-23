package com.rudy.ryanto.core.management.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long userId;
    private String userName;
    private String email;
    private String fullName;
    private String sex;
    private String dob;
    private String placeOfBirth;
    private String idNumber;
    private String idType;
    private String simType;
    private String StreetName;
    private String province;
    private String national;
    private String postalCode;
}
