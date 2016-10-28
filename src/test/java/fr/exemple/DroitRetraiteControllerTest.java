package fr.exemple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebMvcTest(DroitRetraiteController.class)
public class DroitRetraiteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void appelSansDateDeNaissanceAfficheVide() throws Exception {
        this.mvc.perform(get("/ageLegal"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Date de naissance")))
                .andExpect(content().string(not(containsString("années"))));
    }


}