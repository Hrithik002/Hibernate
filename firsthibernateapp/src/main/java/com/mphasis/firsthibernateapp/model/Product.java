package com.mphasis.firsthibernateapp.model;
 
 
import java.math.BigDecimal;
import jakarta.persistence.*;
 
@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "product_type",
    discriminatorType = DiscriminatorType.STRING
)
public abstract class Product {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
    private BigDecimal price;
    private String description;
 
    // Getters and Setters
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public BigDecimal getPrice() {
        return price;
    }
 
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
} 
 