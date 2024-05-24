package org.example.bigs.pretest.test.ping;

import org.example.bigs.pretest.util.PingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PingController.class)
public class PingTest {

    @Autowired
    MockMvc mvc;

    @Test
    void ping() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/ping"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
