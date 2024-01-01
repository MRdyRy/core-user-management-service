package com.rudy.ryanto.core.management.sevice;

import com.rudy.ryanto.core.management.domain.UserDto;
import com.rudy.ryanto.core.management.entity.UserMasterAddress;
import com.rudy.ryanto.core.management.entity.UserMasterData;
import com.rudy.ryanto.core.management.entity.UserMasterDetailData;
import com.rudy.ryanto.core.management.repository.UserAddressRepository;
import com.rudy.ryanto.core.management.repository.UserDetailManagemenrRepository;
import com.rudy.ryanto.core.management.repository.UserManagementRepository;
import com.rudy.ryanto.core.management.service.UserManagementService;
import com.rudy.ryanto.core.management.util.UserManagementConstant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserManagementService.class)
@TestPropertySource(locations = "classpath:application.properties")
public class UserManagementServiceTest {

    @MockBean
    private UserManagementRepository userManagementRepository;

    @MockBean
    private UserDetailManagemenrRepository userDetailManagemenrRepository;

    @MockBean
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserManagementService userManagementService;


    @Before
    public void setup() {
        UserMasterData userMasterData = UserMasterData.builder().userName("rudyryanto")
                .email("ryan@mail.com")
                .id(1L).build();
        doReturn(UserMasterData.builder().build())
                .when(userManagementRepository)
                .save(any(UserMasterData.class));
        doReturn(Optional.of(UserMasterData.builder().build()))
                .when(userManagementRepository)
                .findById(any());

        UserMasterDetailData userMasterDetailData = UserMasterDetailData.builder()
                .idMaster(1L)
                .fullName("rudy ryanto")
                .dob(new Date())
                .sex(UserManagementConstant.Sex.MEN)
                .idNumber("123")
                .idType(UserManagementConstant.IdType.KTP)
                .placeOfBirth("DOB")
                .build();
        doReturn(userMasterDetailData)
                .when(userDetailManagemenrRepository)
                .save(any(UserMasterDetailData.class));
        doReturn(Optional.of(userMasterDetailData))
                .when(userDetailManagemenrRepository)
                .findByIdMaster(any());

        UserMasterAddress userMasterAddress = UserMasterAddress.builder()
                .idMaster(1L)
                .national("INA")
                .StreetName("JL")
                .province("Prov")
                .postalCode("123")
                .build();
        doReturn(userMasterAddress)
                .when(userAddressRepository)
                .save(any(UserMasterAddress.class));
        doReturn(Optional.of(userMasterAddress))
                .when(userAddressRepository)
                .findByIdMaster(any());
    }

    @Test
    public void SaveUserAddressSuccess() throws ParseException {
        var response = userManagementService.doSaveNewUser(userDto());
        Assert.assertTrue(response);
    }

    @Test
    public void SaveUserAddressFailed() throws ParseException {
        doThrow(NullPointerException.class)
                .when(userManagementRepository)
                .save(any(UserMasterData.class));
        var response = userManagementService.doSaveNewUser(userDto());
        Assert.assertFalse(response);
    }


    @Test
    public void findByIdSucess() {
        var response = userManagementService.findById(userDto());
        Assert.assertNotNull(response);
    }

    @Test
    public void findByIdFailed() {
        doReturn(null)
                .when(userAddressRepository)
                .findByIdMaster(any());
        var response = userManagementService.findById(userDto());
        Assert.assertNull(response);
    }

    private UserDto userDto() {
        return UserDto.builder()
                .userName("rudyryanto")
                .email("ryan@mail.com")
                .sex("MEN")
                .dob("1999-08-10")
                .placeOfBirth("ll")
                .national("INA")
                .StreetName("JL")
                .province("Prov")
                .postalCode("123")
                .idNumber("123")
                .idType("KTP")
                .userId(1L)
                .simType("N").build();
    }
}
