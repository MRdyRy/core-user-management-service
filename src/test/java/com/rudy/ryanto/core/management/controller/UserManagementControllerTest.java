package com.rudy.ryanto.core.management.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rudy.ryanto.core.management.domain.UserDto;
import com.rudy.ryanto.core.management.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@RunWith(SpringRunner.class)
@WebMvcTest(UserManagementController.class)
@Slf4j
@AutoConfigureMockMvc
@DisplayName("Wallet controller Test !")
public class UserManagementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserManagementService userManagementService;

    private ObjectMapper obm = new ObjectMapper();
    @Test
    public void AddUserSuccess() throws Exception {
        String url = "/v1/user/add";
        var data = mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(obm.writeValueAsString(userDto())))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("{}", data);
        var response = obm.readValue(data, Boolean.class);
    }

    @Test
    public void FindUserSuccess() throws Exception {
        String url = "/v1/user/find";
        doReturn(new UserDto()).when(userManagementService).findById(any());
        var data = mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(obm.writeValueAsString(userDto())))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("{}", data);
        var response = obm.readValue(data, UserDto.class);
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
