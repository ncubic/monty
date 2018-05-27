package jokes;

import jokes.forms.JokeForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class JokeFormTest {
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
    @WithMockUser(authorities="DEFAULT")
    public void createEmptyJoke() throws Exception {
        mockMvc.perform(
                post("/new")
                .sessionAttr("jokeForm", new JokeForm())
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("jokeForm", "content"))
                .andExpect(model().attributeHasFieldErrors("jokeForm", "category"));
    }

    @Test
    @WithMockUser(authorities="DEFAULT")
    public void createJoke() throws Exception {
        String content = "The cake is a lie";

        mockMvc.perform(
                post("/new")
                    .sessionAttr("jokeForm", new JokeForm())
                    .param("content", content)
                    .param("category", "1")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(model().hasNoErrors());
    }

    @Test(expected = NestedServletException.class)
    @WithMockUser(authorities="DEFAULT")
    public void createJokeWithInvalidCategory() throws Exception {
        String content = "The cake is a lie";

        mockMvc.perform(
                post("/new")
                        .sessionAttr("jokeForm", new JokeForm())
                        .param("content", content)
                        .param("category", "9999")
        );
    }
}
