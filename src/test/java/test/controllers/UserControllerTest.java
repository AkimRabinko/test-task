package test.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import test.services.UserService;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static test.helpers.UserDataCreationHelper.*;

public class UserControllerTest {

    private final UserService userService = mock(UserService.class);

    private final UserController userController = new UserController(userService);
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    @Test
    public void testGetUsersList() throws Exception {
        String expected = "[{\"userId\":{\"firstName\":\"test\",\"lastName\":\"test\"},\"address\":\"test\",\"accounts\":" +
                "[{\"id\":1,\"firstName\":\"test\",\"lastName\":\"test\",\"accountNumber\":\"123456789012\"," +
                "\"accountBalance\":200,\"currency\":\"USD\",\"operations\":{\"id\":1,\"firstName\":\"test\"," +
                "\"lastName\":\"test\",\"accountId\":2,\"totalSum\":120,\"operation\":\"INCOME\"}}]}]";
        when(userService.getUsersList()).thenReturn(Set.of(USER_ENTITY_WITH_ACCOUNT));
        String actual = mockMvc.perform(get("/api/users/list"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(actual, is(expected));
    }

    @Test
    public void testSaveUserVerifyCalls() throws Exception {
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"test\", \"lastName\": \"test\", \"address\": \"test\" }"));
        verify(userService).saveUser(USER_DTO);
    }

    @Test
    public void testDeleteUserVerifyCalls() throws Exception {
        mockMvc.perform(delete("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"test\", \"lastName\": \"test\"}"));
        verify(userService).deleteUser(USER_ID);
    }
}
