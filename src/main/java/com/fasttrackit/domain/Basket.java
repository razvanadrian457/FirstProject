package com.fasttrackit.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket
{
    @Id
    @GeneratedValue(generator = "basket_generator")
    @SequenceGenerator(
            name = "basket_generator",
            sequenceName = "basket_sequence",
            initialValue = 1
    )


    @OneToOne(targetEntity = Basket.class, mappedBy = "products",fetch = FetchType.LAZY)
    @JoinColumn(name="basket_Id")
    private List<Product> products = new ArrayList<>();
    private long id;
    private int totalPrice;
    private User user;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public List<Product> getPrice()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public double computeTotalPrice()
    {
        double total = 0;
        for (Product product : products)
        {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("id=").append(id);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", user=").append(user);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}