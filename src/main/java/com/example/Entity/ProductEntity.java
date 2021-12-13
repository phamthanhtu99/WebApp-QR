package com.example.Entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity extends  BaseEntity{
    @Column
    private String name;
    @Column
    private String image;
    @Column
    private float price;
    @Column
    private float discount_price;
    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "store")
    private StoreEntity store;

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(float discount_price) {
        this.discount_price = discount_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
