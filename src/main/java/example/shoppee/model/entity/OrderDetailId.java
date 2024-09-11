package example.shoppee.model.entity;

import java.io.Serializable;

public class OrderDetailId implements Serializable {
    private Order order;
    private Product product;

    public OrderDetailId() {
    }
    public OrderDetailId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
