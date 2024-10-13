package org.example.warehouse;
import java.math.BigDecimal;
import java.util.UUID;

public record ProductRecord(UUID uuid, String name, Category category, BigDecimal price) {
    public ProductRecord {
        uuid = (uuid == null) ? UUID.randomUUID() : uuid;
        price = (price == null) ? BigDecimal.ZERO : price;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name can't be null or empty.");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category can't be null.");
        }
    }
}
