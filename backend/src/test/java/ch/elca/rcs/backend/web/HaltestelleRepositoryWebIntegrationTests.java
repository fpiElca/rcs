package ch.elca.rcs.backend.web;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ch.elca.rcs.backend.AbstractWebIntegrationTest;
import org.junit.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

public class HaltestelleRepositoryWebIntegrationTests extends AbstractWebIntegrationTest {

    @Test
    public void get_haltestellenAvailable_returnedPaged() throws Exception {
        mvc.perform(get("/api"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("$._links.haltestellen.href", notNullValue()));
    }
}