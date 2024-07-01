// MyData.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.chatwise_api;
import java.util.List;

public class MyData {
    private long total;
    private long limit;
    private long skip;
    private List<Product> products;

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public long getLimit() { return limit; }
    public void setLimit(long value) { this.limit = value; }

    public long getSkip() { return skip; }
    public void setSkip(long value) { this.skip = value; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> value) { this.products = value; }
}

// Product.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Product {
    private double discountPercentage;
    private String thumbnail;
    private List<String> images;
    private long price;
    private double rating;
    private String description;
    private long id;
    private String title;
    private long stock;
    private String category;
    private String brand;

    public double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(double value) { this.discountPercentage = value; }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String value) { this.thumbnail = value; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> value) { this.images = value; }

    public long getPrice() { return price; }
    public void setPrice(long value) { this.price = value; }

    public double getRating() { return rating; }
    public void setRating(double value) { this.rating = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public long getStock() { return stock; }
    public void setStock(long value) { this.stock = value; }

    public String getCategory() { return category; }
    public void setCategory(String value) { this.category = value; }

    public String getBrand() { return brand; }
    public void setBrand(String value) { this.brand = value; }
}
