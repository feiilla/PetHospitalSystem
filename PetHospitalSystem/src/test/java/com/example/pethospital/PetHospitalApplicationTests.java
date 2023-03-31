package com.example.pethospital;

import com.example.pethospital.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PetHospitalApplicationTests {
    @Autowired
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();;

    @Test
    void databaseTest(){
        
    }

}
