package com.mandacarubroker;

import com.mandacarubroker.domain.stock.RequestStockDTO;
import com.mandacarubroker.domain.stock.Stock;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StockTests {

	@Test
	void testCreateStockInstanceWithRequestStockDTO() {
		// Arrange
		RequestStockDTO requestStockDTO = new RequestStockDTO("XYZ", "XYZ Corporation", 50.0);

		// Act
		Stock stock = new Stock(requestStockDTO);

		// Assert
		Assertions.assertEquals("XYZ", stock.getSymbol(), "Symbol should match");
		Assertions.assertEquals("XYZ Corporation", stock.getCompanyName(), "Company name should match");
		Assertions.assertEquals(50.0, stock.getPrice(), 0.001, "Price should match");
	}

	@Test
	void testIncreasePrice() {
		// Arrange
		Stock stock = new Stock("asd", "CC4", "COMPANY1", 11);

		// Act
		stock.changePrice(4, true);

		// Assert
		Assertions.assertEquals(15, stock.getPrice(), "Teste de aumento de preço");
	}

	@Test
	void testDecreasePrice() {
		// Arrange
		Stock stock = new Stock("asd", "CC4", "COMPANY1", 10);

		// Act
		stock.changePrice(5, false);

		// Assert
		Assertions.assertEquals(5, stock.getPrice(), "Teste de diminuição de preço");
	}
	@Test
	void testChangePrice() {
		// Arrange
		Stock stock = new Stock("asd", "CC4", "COMPANY1", 10);

		// Act
		stock.changePrice(1, true);

		// Assert
		Assertions.assertEquals(11, stock.getPrice(), "Mundando preço de 10 para 11");
	}

}

class RequestStockDTOTest {
	@Test
	void testCreateValidRequestStockDTO() {
		// Arrange
		String symbol = "ABC1";
		String companyName = "Company XYZ";
		double price = 50.0;

		// Act
		RequestStockDTO requestStockDTO = new RequestStockDTO(symbol, companyName, price);

		// Assert
		Assertions.assertEquals(symbol, requestStockDTO.symbol(), "Symbol should match");
		Assertions.assertEquals(companyName, requestStockDTO.companyName(), "Company name should match");
		Assertions.assertEquals(price, requestStockDTO.price(), 0.001, "Price should match");
	}

}