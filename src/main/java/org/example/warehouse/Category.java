package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static final Map<String, Category> categories = new HashMap<>();
    private final String name;

    private Category(String name) {
        this.name = capitalizeFirstLetter(name);
    }

    public static Category of(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }
        return categories.computeIfAbsent(name.toLowerCase(), Category::new);
    }

    public String getName() {
        return name;
    }

    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
