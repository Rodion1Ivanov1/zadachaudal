package stack.overflow.backend.controller;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import stack.overflow.backend.IntegrationTestContext;


import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
public class ModeratorTagRestControllerTest extends IntegrationTestContext {

    @Sql(executionPhase = BEFORE_TEST_METHOD, value = "/sql/ModeratorTagRestControllerTest/deleteTagsTest/before.sql")
    @Sql(executionPhase = AFTER_TEST_METHOD, value = "/sql/ModeratorTagRestControllerTest/deleteTagsTest/after.sql")
    @Test
    public void deleteTagsTest() throws Exception {
        Integer id = 1;
        String token = testUtil.getToken("user1", "password");
        mockMvc.perform(delete("/api/v1/moderator/tags/{tagId}", id)
                        .header("authorization", "Bearer " + token))
                .andExpect(status().isOk());

    }

}
