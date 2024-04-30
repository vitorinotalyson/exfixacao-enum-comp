package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM" +
            "/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Client client;


    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem orders){
        items.add(orders);
    }
    public void removeItem(OrderItem orders){
        items.remove(orders);
    }

    public Double total(){
        double sum = 0;
        for (OrderItem item : items){
            sum += item.subTotal();
        }
        return sum;
    }
}
