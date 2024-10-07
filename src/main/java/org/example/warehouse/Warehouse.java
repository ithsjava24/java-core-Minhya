package org.example.warehouse;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.IntPredicate;

public class Warehouse {
    private static String myStore;
    Scanner scanner = new Scanner(System.in);

    private Warehouse Warehouse;
    private Warehouse(String myStore) {
        this.myStore = myStore;
    }

    // Overloaded private constructor in case no store is provided
    private Warehouse() {
        this.myStore = "Default Store"; // You can set a default store name here
    }

    public static Warehouse getInstance(String myStore) {
        //org.example.warehouse.Warehouse.myStore = myStore;


    }

    public boolean isEmpty() {
    }

    public ProductRecord addProduct(UUID uuidMilk, String milk, Category dairy, BigDecimal bigDecimal) {

    }

    public boolean getProducts() {
    }

    public boolean getProductById(IntPredicate uuid) {
    }

    public void updateProductPrice(IntPredicate uuid, BigDecimal bigDecimal) {
    }

    public boolean getChangedProducts() {
    }

    public boolean getProductsGroupedByCategories() {
    }

    public boolean getProductsBy(Category meat) {
    }








}
