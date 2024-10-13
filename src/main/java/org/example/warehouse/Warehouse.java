package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
    private final String name;
    private static Map<String, Warehouse> instances = new HashMap<>();
    private List<ProductRecord> products = new ArrayList<>();
    private Set<ProductRecord> changedProducts = new HashSet<>();
    private Warehouse Warehouse;

    private Warehouse(String myStore) {
        this.name = myStore;
    }

    public static Warehouse getInstance(String myStore) {
        return instances.computeIfAbsent(myStore, Warehouse::new);
    }

    public static Warehouse getInstance() {
        return new Warehouse(" ");
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public List<ProductRecord> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Optional<ProductRecord> getProductById(UUID uuid) {
        return products.stream()
                .filter(product -> product.uuid().equals(uuid))
                .findFirst();
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        return products.stream()
                .collect(Collectors.groupingBy(ProductRecord::category));
    }

    public List<ProductRecord> getProductsBy(Category category) {
        return products.stream()
                .filter(product -> product.category().equals(category))
                .collect(Collectors.toList());
    }

    public void updateProductPrice(UUID uuid, BigDecimal price) {
        products.stream()
                .filter(product -> product.uuid().equals(uuid))
                .findAny()
                .ifPresentOrElse(product -> changedProducts.add(product),
                        () -> {
                            throw new IllegalArgumentException("Product with that id doesn't exist.");
                        });
        products.replaceAll(product -> product.uuid().equals(uuid) ? new ProductRecord(product.uuid(), product.name(), product.category(), price) :
                product);
    }

    public Set<ProductRecord> getChangedProducts() {
        return changedProducts;
    }

    public ProductRecord addProduct(UUID uuid, String milk, Category dairy, BigDecimal price) {
        products.stream()
                .filter(product -> product.uuid().equals(uuid))
                .findAny()
                .ifPresent(existingProduct -> {
                    throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
                });

        ProductRecord newProduct = new ProductRecord(uuid, milk, dairy, price);
        products.add(newProduct);

        return newProduct;
    }
}
