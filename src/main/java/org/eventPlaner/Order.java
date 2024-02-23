package org.eventPlaner;


public class Order {

    String orderId;
   String status;

    public Order() {
        // Generate an order ID and set default status, for simplicity assuming these are set here
        this.orderId = "ORD" + System.currentTimeMillis(); // Simplistic way to generate a unique ID
        this.status = "NEW";
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
