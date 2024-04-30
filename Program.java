import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (dd/MM/yyyy): ");
        String birthDate = sc.nextLine();
        Client client = new Client(name,email,sdf.parse(birthDate));
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStats = sc.nextLine();
        Order order = new Order(new Date(), OrderStatus.valueOf(orderStats),
                client);
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0;i < n; i++){
            System.out.printf("Enter #%d item data: \n",i+1);
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantityProduct = sc.nextInt();
            sc.nextLine();
            OrderItem orders = new OrderItem(quantityProduct,priceProduct,
                    new Product(nameProduct,priceProduct));
            order.addItem(orders);
        }
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);
        System.out.print("Total price: $ ");
        Double total = order.total();
        System.out.print(total);
        sc.close();
    }
}
