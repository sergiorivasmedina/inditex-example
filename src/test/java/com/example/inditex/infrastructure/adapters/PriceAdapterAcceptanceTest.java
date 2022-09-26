package com.example.inditex.infrastructure.adapters;

import com.example.inditex.infrastructure.Sample;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceAdapterAcceptanceTest {
    /* Se desarrollan los test al endpoint rest que validen las peticiones al servicio con los datos del ejemplo */

    private final static String ENDPOINT = "/price/validate-final";

    private final static String DATE_TEST1 = "2020-06-14-10.00.00";
    private final static String DATE_TEST2 = "2020-06-14-16.00.00";
    private final static String DATE_TEST3 = "2020-06-14-21.00.00";
    private final static String DATE_TEST4 = "2020-06-15-10.00.00";
    private final static String DATE_TEST5 = "2020-06-16-21.00.00";

    @Autowired
    private MockMvc mvc;

    @Test
    void executeTest1() throws Exception {

        mvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(Sample.buildPriceRequest(DATE_TEST1)))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31-23.59.59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }

    @Test
    void executeTest2() throws Exception {

        mvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Sample.buildPriceRequest(DATE_TEST2)))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14-15.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14-18.30.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
    }

    @Test
    void executeTest3() throws Exception {

        mvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Sample.buildPriceRequest(DATE_TEST3)))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31-23.59.59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }

    @Test
    void executeTest4() throws Exception {

        mvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Sample.buildPriceRequest(DATE_TEST4)))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(3L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15-11.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50));
    }

    @Test
    void executeTest5() throws Exception {

        mvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Sample.buildPriceRequest(DATE_TEST5)))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(4L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15-16.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31-23.59.59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));
    }

    @Test
    void shouldReturnNotFound() throws Exception {

        mvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Sample.buildPriceRequest("2021-01-01-00.00.00")))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
