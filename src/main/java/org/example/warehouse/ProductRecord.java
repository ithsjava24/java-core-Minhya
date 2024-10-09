package org.example.warehouse;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.IntPredicate;

public record ProductRecord(UUID uuid, String name, Category category, BigDecimal price) {
    public ProductRecord(UUID uuid, String name, Category category, BigDecimal price){
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.name = name;
        this.category = category;
        this.price = price == null ? BigDecimal.ZERO : price;


        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Product name can't be null or empty.");

        }
        if (category == null){
            throw new IllegalArgumentException("Category can't be null.");
        }
    }


////    public UUID uuid() {
////        return uuid;
////    }
////
////    public BigDecimal price() {
////        return price;
////    }
////    public Category category() {
////        return category;
////    }
//
//
//    public static IntPredicate uuid(){
//
//        return uuid;
//    }
//
//    public boolean price() {
//        return price;
//    }
//
//    public Category category() {
//        return category;
//    }
}
