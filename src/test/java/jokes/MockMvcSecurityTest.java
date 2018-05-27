package jokes;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class MockMvcSecurityTest {
    protected MockMvc mockMvc;
 
    @Autowired
    private WebApplicationContext webApplicationContext;
 
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }
 
    @Test
    public void indexWithAnonymous() throws Exception {
        mockMvc.perform(
            get("/")
        ).andExpect(status().isOk());
    }

    @Test
    public void newWithAnonymous() throws Exception {
        mockMvc.perform(
            get("/new")
        ).andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    public void postNewWithAnonymous() throws Exception {
        mockMvc.perform(
            post("/new")
        ).andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    @WithMockUser(authorities="DEFAULT")
    public void newWithAuthorized() throws Exception {
        mockMvc.perform(
            get("/new")
        ).andExpect(status().isOk());
    }
}