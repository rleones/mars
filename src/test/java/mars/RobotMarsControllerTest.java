package mars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by roberto on 26/03/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RobotMarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamMarsShouldReturnClientError() throws Exception {
        this.mockMvc.perform(post("/rest/mars/")).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void paramMMShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/MM")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(0, 2, N)"));
    }

    @Test
    public void paramMMMShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/MMM")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(0, 3, N)"));
    }

    @Test
    public void paramLShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/L")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(0, 0, W)"));
    }

    @Test
    public void paramRShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/R")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(0, 0, E)"));
    }

    @Test
    public void paramLRMMMShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/LRMMM")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(0, 3, N)"));
    }

    @Test
    public void paramRMLMMShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/RMLMM")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(1, 2, N)"));
    }

    @Test
    public void paramMMRMMRMMShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/MMRMMRMM")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(2, 0, S)"));
    }

    @Test
    public void paramMMLShouldReturnValidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/MML")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("(0, 2, W)"));
    }

    @Test
    public void paramAAAShouldReturnInvalidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/AAA")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void paramMMMMMMShouldReturnInvalidMoves() throws Exception {
        this.mockMvc.perform(post("/rest/mars/MMMMMM")).andDo(print()).andExpect(status().isBadRequest());
    }


}
