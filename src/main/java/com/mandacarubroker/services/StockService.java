package com.mandacarubroker.services;

import com.mandacarubroker.helpers.RequestStockDTO;
import com.mandacarubroker.domain.Stock;
import com.mandacarubroker.domain.StockRepository;

import jakarta.validation.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(final StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(final String id) {
        return stockRepository.findById(id);
    }

    public Stock createStock(final RequestStockDTO data) {
        validateRequestStockDTO(data);
        final Stock newAction = new Stock(data);
        return stockRepository.save(newAction);
    }

    public Optional<Stock> updateStock(final String id, final Stock updatedStock) {
        return stockRepository.findById(id).map(stock -> {
            stock.setSymbol(updatedStock.getSymbol());
            stock.setCompanyName(updatedStock.getCompanyName());
            final double newPrice = stock.changePrice(updatedStock.getPrice(), true);
            stock.setPrice(newPrice);
            return stockRepository.save(stock);
        });
    }

    public void deleteStock(final String id) {
        stockRepository.deleteById(id);
    }

    public static void validateRequestStockDTO(final RequestStockDTO data) {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();
        final Set<ConstraintViolation<RequestStockDTO>> violations = validator.validate(data);

        if (!violations.isEmpty()) {
            final StringBuilder errorMessage = new StringBuilder("Validation failed. Details: ");

            for (final ConstraintViolation<RequestStockDTO> violation : violations) {
                errorMessage.append(String.format("[%s: %s], ", violation.getPropertyPath(), violation.getMessage()));
            }

            errorMessage.delete(errorMessage.length() - 2, errorMessage.length());
            throw new ConstraintViolationException(errorMessage.toString(), violations);
        }
    }

    public void validateAndCreateStock(final RequestStockDTO data) {
        validateRequestStockDTO(data);
        final Stock novaAcao = new Stock(data);
        stockRepository.save(novaAcao);
    }
}
