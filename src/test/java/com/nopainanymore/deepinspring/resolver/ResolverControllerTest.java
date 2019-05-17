package com.nopainanymore.deepinspring.resolver;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * deep-in-spring: ResolverControllerTest
 *
 * @author NoPainAnymore
 * @date 2019-05-17 23:08
 */
public class ResolverControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ResolverController resolverController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(resolverController)
                .setCustomArgumentResolvers(new UserArgumentResolver())
                .build();
    }

    @Test
    public void user() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", User.builder().userId("1").userName("nopainanymore").build());
        mockMvc.perform(get("/resolver/user")
                .contentType(MediaType.APPLICATION_JSON)
                .session(session)).andExpect(status().isOk());
    }

}