package org.progresssoft;
import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.progresssoft.warehouse.WarehousController;
import org.progresssoft.warehouse.WarhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class) 
@SpringBootTest
@AutoConfigureMockMvc
public class WareHouseControllerTest {

    @MockBean
    private WarhouseRepository warehouseRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void addDealValidatorPassed() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String deal = "{\"dealId\": \"38292\", \"amount\" : 33020, \"orderCurrencyCode\": \"USD\", \"exchangeCurrencyCode\": \"EUR\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/api/v1/warehouse/add")
        .content(deal)
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.status().isOk())
         .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }

    
    
}
