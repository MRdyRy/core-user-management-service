package com.rudy.ryanto.core.management.service;

import com.rudy.ryanto.core.management.domain.UserDto;
import com.rudy.ryanto.core.management.entity.UserMasterAddress;
import com.rudy.ryanto.core.management.entity.UserMasterData;
import com.rudy.ryanto.core.management.entity.UserMasterDetailData;
import com.rudy.ryanto.core.management.repository.UserAddressRepository;
import com.rudy.ryanto.core.management.repository.UserDetailManagemenrRepository;
import com.rudy.ryanto.core.management.repository.UserManagementRepository;
import com.rudy.ryanto.core.management.util.Formatter;
import com.rudy.ryanto.core.management.util.UserManagementConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Optional;

@Service
@Slf4j
public class UserManagementService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    @Autowired
    private UserDetailManagemenrRepository userDetailManagemenrRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @SuppressWarnings("all")
    public Boolean doSaveNewUser(UserDto req) throws ParseException {
        log.info("doSaveNewUser : {}",req);
        Boolean isSuccess = Boolean.FALSE;
        try {
            var masterData = userManagementRepository.save(UserMasterData.builder()
                            .userName(req.getUserName())
                            .email(req.getEmail())
                            .status(UserManagementConstant.Status.REGISTERED)
                    .build());

            var detail = userDetailManagemenrRepository.save(UserMasterDetailData.builder()
                            .idMaster(masterData.getId())
                            .fullName(req.getFullName())
                            .sex(UserManagementConstant.Sex.valueOf(req.getSex()))
                            .dob(Formatter.sdf.parse(req.getDob()))
                            .idType(UserManagementConstant.IdType.valueOf(req.getIdType()))
                            .idNumber(req.getIdNumber())
                            .simType(UserManagementConstant.SIMType.valueOf(req.getSimType()))
                            .placeOfBirth(req.getPlaceOfBirth())
                    .build());

            var address = userAddressRepository.save(UserMasterAddress.builder()
                            .idMaster(masterData.getId())
                            .national(req.getNational())
                            .postalCode(req.getPostalCode())
                            .province(req.getProvince())
                            .StreetName(req.getStreetName())
                    .build());

            if(masterData!=null && detail!=null && address!=null)
                isSuccess = Boolean.TRUE;

        }catch (Exception e){
            throw e;
        }
        return isSuccess;
    }

    @Transactional(readOnly = true)
    public UserDto findById(UserDto req){
        log.info("findbyid : {}",req);
        UserDto userDto1 = null;
        try {
            var m = userManagementRepository.findById(req.getUserId());
            var d = userDetailManagemenrRepository.findByIdMaster(req.getUserId());
            var a = userAddressRepository.findByIdMaster(req.getUserId());
            if(m.isPresent() && d.isPresent() && a.isPresent())
                userDto1 = doMappingResponse(m, d, a);
        }catch (Exception e){
            throw e;
        }
        return userDto1;
    }

    @SuppressWarnings("all")
    private static UserDto doMappingResponse(Optional<UserMasterData> m, Optional<UserMasterDetailData> d, Optional<UserMasterAddress> a) {
        return UserDto.builder()
                .dob(Formatter.sdf.format(d.get().getDob()))
                .email(m.get().getEmail())
                .userId(m.get().getId())
                .sex(String.valueOf(d.get().getSex()))
                .fullName(d.get().getFullName())
                .idNumber(d.get().getIdNumber())
                .idType(String.valueOf(d.get().getIdType()))
                .simType(String.valueOf(d.get().getSimType()))
                .userName(m.get().getUserName())
                .national(a.get().getNational())
                .placeOfBirth(d.get().getPlaceOfBirth())
                .postalCode(a.get().getPostalCode())
                .province(a.get().getProvince())
                .StreetName(a.get().getStreetName())
                .build();
    }
}
