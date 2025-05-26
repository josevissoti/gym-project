    package com.project.domains;

    import com.project.domains.dtos.OrderItemDTO;
    import jakarta.persistence.*;

    import java.util.Objects;

    @Entity
    @Table(name = "orderItems")
    public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orderitem")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "idproduct")
        private Product product;

        @ManyToOne
        @JoinColumn(name = "idserviceOrder")
        private ServiceOrder serviceOrder;

        private int quantity;

        public OrderItem(Long id, ServiceOrder serviceOrder, Product product, int quantity) {
            this.id = id;
            this.serviceOrder = serviceOrder;
            this.product = product;
            this.quantity = quantity;
        }

        public OrderItem(OrderItemDTO orderItemDTO) {
            this.quantity = orderItemDTO.getQuantity();
        }

        public OrderItem() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public ServiceOrder getServiceOrder() {
            return serviceOrder;
        }

        public void setServiceOrder(ServiceOrder serviceOrder) {
            this.serviceOrder = serviceOrder;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            OrderItem that = (OrderItem) o;
            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }
    }
