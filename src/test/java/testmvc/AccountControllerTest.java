package testmvc;


import core.entites.Account;
import core.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.mvc.AccountController;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is ;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class AccountControllerTest {
    @InjectMocks
    private AccountController controller;
    @Mock
    private AccountService service ;
    private MockMvc mockMvc ;

    @Before
    public void setup () {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingUser () throws Exception {
        Account user = new Account();
        user.setName("Ime ");
        user.setPassword("password");
        user.setId(1L);

       // when(service.find(1L)).thenReturn(user);
        mockMvc.perform(get("/rest/users/1"))
                .andDo(print())
                .andExpect(jsonPath("$.name", is(user.getName())))
               //.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/users/1"))))
                .andExpect(status().isOk());


    }
}
