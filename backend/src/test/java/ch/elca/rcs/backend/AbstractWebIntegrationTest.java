package ch.elca.rcs.backend;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.LinkDiscoverer;
import org.springframework.hateoas.LinkDiscoverers;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractWebIntegrationTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    LinkDiscoverers links;

    protected MockMvc mvc;

    @Before
    public void setUp() {

        mvc = MockMvcBuilders.webAppContextSetup(context)
                .defaultRequest(MockMvcRequestBuilders.get("/web").locale(Locale.US))
                .build();
    }

    /**
     * Creates a {@link ResultMatcher} that checks for the presence of a link with the given rel.
     *
     * @param rel
     * @return
     */
    protected ResultMatcher linkWithRelIsPresent(final String rel) {
        return new LinkWithRelMatcher(rel, true);
    }

    /**
     * Creates a {@link ResultMatcher} that checks for the non-presence of a link with the given rel.
     *
     * @param rel
     * @return
     */
    protected ResultMatcher linkWithRelIsNotPresent(String rel) {
        return new LinkWithRelMatcher(rel, false);
    }

    protected LinkDiscoverer getDiscovererFor(MockHttpServletResponse response) {
        return links.getLinkDiscovererFor(response.getContentType());
    }

    private class LinkWithRelMatcher implements ResultMatcher {

        private final String rel;
        private final boolean present;

        public LinkWithRelMatcher(String rel, boolean present) {
            this.rel = rel;
            this.present = present;
        }

        /*
         * (non-Javadoc)
         * @see org.springframework.test.web.servlet.ResultMatcher#match(org.springframework.test.web.servlet.MvcResult)
         */
        @Override
        public void match(MvcResult result) throws Exception {

            MockHttpServletResponse response = result.getResponse();
            String content = response.getContentAsString();
            LinkDiscoverer discoverer = links.getLinkDiscovererFor(response.getContentType());

            Assertions.assertThat(discoverer.findLinkWithRel(rel, content)).matches(it -> present == (it != null));
        }
    }
}