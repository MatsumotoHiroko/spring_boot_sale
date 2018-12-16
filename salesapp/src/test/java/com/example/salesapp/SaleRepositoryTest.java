package com.example.salesapp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleRepositoryTest {

	@Qualifier("saleRepository")
    @Autowired
    SaleRepository repository;
	Sale sale1;
	String title1 = "testitem1";
	
	@Before
    public void setUp() {
		sale1 = new Sale();
		sale1.setTitle(title1);
		sale1.setDescription("test description");
		sale1.setPrice(100);
		sale1.setStock(50);
		sale1.setCountry("Japan");
		sale1.setState("Tokyo");
		sale1.setCity("Chiyoda");
		sale1.setStreet("1-7-1 Nagata");
		sale1.setLatitude(35.67571);
		sale1.setLongitude(139.74481);
	
		repository.save(sale1);
        
	}
	
	@Test
    public void readsSaleByTitle() {

        List<Sale> result = repository.findByTitle(title1);
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	@Test
    public void readsSaleByCountry() {

        List<Sale> result = repository.findByCountry("Japan");
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	@Test
    public void readsSaleByState() {

        List<Sale> result = repository.findByState("Tokyo");
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	@Test
    public void readsSaleByCity() {

        List<Sale> result = repository.findByCity("Chiyoda");
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	@Test
    public void readsSaleByDescriptionLike() {

        List<Sale> result = repository.findByDescriptionLike("description");
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	
	@Test
    public void readsSaleByStreetLike() {

        List<Sale> result = repository.findByStreetLike("Nagata");
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	@Test
    public void readsSaleByPriceBetween() {

        int grater = 99;
        int less = 101;
        List<Sale> result = repository.findByPriceBetween(grater, less);
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	
	@Test
    public void readsSaleByStockBetween() {

        int grater = 49;
        int less = 51;
        List<Sale> result = repository.findByStockBetween(grater, less);
        assertEquals(result.get(0).getTitle(), title1); 
    }
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
}

