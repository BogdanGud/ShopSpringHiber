package com.andersen.shop.controller;


import com.andersen.shop.model.Customer;
import com.andersen.shop.model.Product;
import com.andersen.shop.service.BookingService;
import com.andersen.shop.service.CustomerService;
import com.andersen.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookingService bookingService;

    public void start() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("1 - add new product \n" +
                        "2 - print all products \n" +
                        "3 - add new customer \n" +
                        "4 - print all customers \n" +
                        "5 - print all orders \n" +
                        "6 - add new order \n" +
                        "7 - delete order \n" +
                        "8 - delete product \n" +
                        "9 - delete customer \n" +
                        "q - for quit \n");
                String input = reader.readLine();
                switch (input) {
                    case "1":
                        System.out.println("Input name for new product: ");
                        String productName = reader.readLine();
                        System.out.println("Input price for new product: ");
                        String productPrice = reader.readLine();
                        this.addProduct(productName, productPrice);
                        break;
                    case "2":
                        this.printAllProducts();
                        break;

                    case "3":
                        System.out.println("Input name for new customer: ");
                        String customerName = reader.readLine();
                        System.out.println("Input phone number for new customer: ");
                        String phoneNumber = reader.readLine();
                        System.out.println("Input address for new customer: ");
                        String address = reader.readLine();
                        this.addCustomer(customerName, phoneNumber, address);
                        break;
                    case "4":
                        this.printAllCustomers();
                        break;
                    case "5":
                        this.printAllOrders();
                        break;
                    case "6":
                        System.out.println("Input customer Id for new order: ");
                        Integer customerId = Integer.valueOf(reader.readLine());
                        System.out.println("Input date for new order in format MM/dd/yyyy: ");
                        String strdate = reader.readLine();
                        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        Date date = df.parse(strdate);
                        System.out.println("Input product Id for new order: ");
                        Integer productId = Integer.valueOf(reader.readLine());
                        this.addOrder(customerId, date, productId);
                        break;
                    case "7":
                        System.out.println("Please enter order id to be deleted :");
                        Integer orderId = Integer.valueOf(reader.readLine());
                        this.deleteOrderById(orderId);
                        break;
                    case "8":
                        System.out.println("Please enter product id to be deleted :");
                        Integer productDeleteId = Integer.valueOf(reader.readLine());
                        this.deleteProductById(productDeleteId);
                        break;
                    case "9":
                        System.out.println("Please enter customer id to be deleted :");
                        Integer customerDeleteId = Integer.valueOf(reader.readLine());
                        this.deleteCustomerById(customerDeleteId);
                        break;
                    case "q":
                        System.out.println("Exit!");
                        System.exit(0);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Caught exception" + e);
        }
    }


    private void addProduct(String name, String price) {
        productService.create(new Product(name, new BigDecimal(price)));
    }

    private void printAllProducts() {
        System.out.println(productService.getAll());
    }


    private void addCustomer(String name, String phone, String address) {
        customerService.create(new Customer(name, phone, address));
    }

    private void printAllCustomers() {
        System.out.println(customerService.getAll());
    }

    private void printAllOrders() {
        System.out.println(bookingService.getAll());
    }

    private void addOrder(int customerId, Date date, int productId) {
        bookingService.createNewOrder(customerId, date, productId);
    }

    private void deleteOrderById(int id) {
        bookingService.delete(id);
    }

    private void deleteProductById(int id) {
        productService.delete(id);
    }

    private void deleteCustomerById(int id) {
        customerService.delete(id);
    }


    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}
