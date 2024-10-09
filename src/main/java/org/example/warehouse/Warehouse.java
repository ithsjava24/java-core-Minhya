package org.example.warehouse;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.IntPredicate;

public class Warehouse {
    // testet når inte "name" kan det bero på något som står innan Typen
    private final String name;
    private static Map<String, Warehouse> instances = new HashMap<>();
    private List<ProductRecord> products = new ArrayList<>();
    private List<ProductRecord> changedProducts = new ArrayList<>();
    private Warehouse Warehouse;

    private Warehouse(String myStore) {
        this.name = myStore;
    }

    // Overloaded private construct ifall ingen store finns
    private Warehouse() {
        this.name = "MyStore"; // You can set a default store name here
    }

    public static Warehouse getInstance(String myStore) {
        //org.example.warehouse.Warehouse.myStore = myStore;

        return instances.computeIfAbsent(myStore, Warehouse::new);
    }
    public static Warehouse getInstance() {
        //org.example.warehouse.Warehouse.myStore = myStore;
        return new Warehouse(" ");
       // return instances.computeIfAbsent("MyStore", name -> new Warehouse());
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }



    public List<ProductRecord> getProducts() {
        return products;

        //return false;
    }

    public List<ProductRecord> getProductById(UUID uuid) {
        List<ProductRecord> IDs= new ArrayList<>();
        for (ProductRecord productUUID : products) {
            if(uuid==productUUID.uuid()){
                IDs.add(productUUID);
                }
        }

        return IDs;
    }


    public boolean getChangedProducts() {
//        addProduct()
        return false;

    }


    public boolean getProductsGroupedByCategories() {
        return false;
    }

    public List<ProductRecord> getProductsBy(Category category) {
        List<ProductRecord> sameCategory = new ArrayList<>();
        for (ProductRecord productUUID : products) {
            if(category==productUUID.category()){
                sameCategory.add(productUUID);
            }
        }

        return sameCategory;
    }


    public List<ProductRecord> updateProductPrice(UUID uuid, BigDecimal price) {
        for(ProductRecord changePriceToSaveIt : products){
            if(changePriceToSaveIt.uuid().equals(uuid)){
                changePriceToSaveIt.name();
                changePriceToSaveIt.category();
                ProductRecord changePriceToSaveItToList = new ProductRecord(uuid,name,changePriceToSaveIt.category(),price);
                int index = products.indexOf(changePriceToSaveIt);
                products.set(index, changePriceToSaveItToList);
            }
        }
        return products;
    }

    public ProductRecord addProduct(UUID uuid, String milk, Category dairy, BigDecimal bigDecimal) {
        ProductRecord product = new ProductRecord(uuid, milk, dairy, bigDecimal);

        for(ProductRecord eachProduct : products) {
            if(uuid==eachProduct.uuid()){
                throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
            }
        }
        products.add(product);

        return product;
    }

}
