import java.util.*;

public class MealDeliveryService {

    // instance variables
    private String customerName;
    private String deliveryAddress;
    private String mealPlan;
    private ArrayList<String> orders;
    private int deliveryCharge;
    private final double TAX_RATE = 0.06;

    // default constructor
    public MealDeliveryService() {
        this.customerName = "";
        this.deliveryAddress = "";
        this.mealPlan = "";
        this.orders = new ArrayList<String>();
        this.deliveryCharge = 0;
    }

    // parameterized constructor
    public MealDeliveryService(String customerName, String deliveryAddress, String mealPlan) {
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.mealPlan = mealPlan;
        this.orders = new ArrayList<String>();
        this.deliveryCharge = 0;
    }

    // getters and setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    public String getMealPlan() {
        return this.mealPlan;
    }

    public int getDeliveryCharge() {
        return this.deliveryCharge;
    }

    // methods
    public void addOrder(String order) {
        this.orders.add(order);
    }

    public void removeOrder(int index) {
        this.orders.remove(index);
    }

    public void calculateDeliveryCharge() {
        if (this.mealPlan.equals("Weekly")) {
            this.deliveryCharge = 100;
        } else if (this.mealPlan.equals("Monthly")) {
            this.deliveryCharge = 200;
        } else {
            this.deliveryCharge = 0;
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0;

        for (String order : this.orders) {
            double price = getMealPrice(order);
            totalCost += price;
        }

        totalCost += this.deliveryCharge;
        totalCost *= (1 + this.TAX_RATE);

        return totalCost;
    }

    public double getMealPrice(String mealName) {
        double price = 0;

        if (mealName.equals("Burger")) {
            price = 10.99;
        } else if (mealName.equals("Pizza")) {
            price = 12.99;
        } else if (mealName.equals("Pasta")) {
            price = 11.99;
        } else if (mealName.equals("Salad")) {
            price = 8.99;
        }

        return price;
    }

    public void printOrderDetails() {
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Delivery Address: " + this.deliveryAddress);
        System.out.println("Meal Plan: " + this.mealPlan);
        System.out.println("Orders: ");

        for (String order : this.orders) {
            double price = getMealPrice(order);
            System.out.println(order + " - $" + price);
        }

        System.out.println("Delivery Charge: $" + this.deliveryCharge);
        System.out.println("Tax Rate: " + this.TAX_RATE);
        double totalCost = calculateTotalCost();
        System.out.println("Total Cost: $" + totalCost);
    }

}