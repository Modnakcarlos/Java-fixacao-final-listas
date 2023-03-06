package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    
    private Date moment;
    private OrderStatus status;
    private Client client;


    public List<OrderItem> order = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        super();
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public Date getMoment() {
        return moment;
    }

    public void getStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(OrderItem item) {
        order.add(item);
    }

    public void removeItem(OrderItem item) {
        order.remove(item);
    }

    public List<OrderItem> getItems() {
        return order;
    }

//    public OrderItem getOrderItem() {
//       return ;
//   }


    public void setCLient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public Double total() {
        double soma = 0;
        for(OrderItem c : order) {
            soma += c.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : order) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
        
    }
}
