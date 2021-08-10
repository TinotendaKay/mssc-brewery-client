package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto dto = BeerDto.builder().build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), dto);

    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());

    }


    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto dto = CustomerDto.builder().build();
        URI uri = client.saveNewCustomer(dto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto dto = CustomerDto.builder().name("New Customer").build();
        client.updateCustomer(UUID.randomUUID(), dto);

    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());

    }
}