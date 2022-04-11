package com.groep3.bestel.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer tableId;

    @Column
    private Integer orderState = null;

    @Column
    private Integer assignedEmployee = null;

    @Column
    long time = Instant.now().getEpochSecond();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    public List<Product> products;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Integer getOrderState() {return this.orderState;}
    public void setOrderState(Integer orderState) {this.orderState = orderState;}

    public long getTime() {return this.time;}
    public void setTime(long time) {this.time = time;}

    public Integer getAssignedEmployee() {return this.assignedEmployee;}
    public void setAssignedEmployee(Integer assignedEmployee) {this.assignedEmployee = assignedEmployee;}

    public List<Product> getProducts() {return this.products;}
    public void setProducts(List<Product> products) {
        this.products = products;

        for (Product product : products) {
            product.setOrder(this);
        }
    }

    public Integer getTableId() {return tableId;}
    public void setTableId(Integer TableId) {tableId = TableId;}
}
