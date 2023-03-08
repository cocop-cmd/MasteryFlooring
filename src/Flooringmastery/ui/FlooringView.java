package Flooringmastery.ui;

import dto.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FlooringView {

    private UserIO io;
    public FlooringView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("<<Flooring Program>>");
        io.print("1. Display Orders");
        io.print("2. Add Order");
        io.print("3. Edit Order");
        io.print("4. Remove Order");
        io.print("5. Export All Data");
        io.print("6. Quit");

        return io.readInt("Please select from the above choices", 1, 6);
    }

    public void displayDisplayOrderBanner() {
        io.print("<<<<< Display Orders >>>>");

    }

    public LocalDate inputDate() {
        return io.readDate("Please enter a date. (MM-DD-YYYY)",
                LocalDate.of(2023, 3, 6), LocalDate.of(2060, 1, 31));
    }

    public String CustomerName() {

        return io.readString("Please enter the customer's name");
    }

    public String State() {
        return io.readString("Please enter the state" + "(Ex. Montana",13) ;
    }

    public String ProductType() {
        return io.readString("PLease enter the product type", 15);
    }

    public BigDecimal Area() {
        return io.readBigDecimal("Please enter the area of your project"
                + "in square feet.", 2, BigDecimal.ZERO);
    }

    public void displayDateBanner(LocalDate dateChoice) {
        System.out.printf("<<< Orders on %s >>>\n", dateChoice);
    }


    public void displayDateOrders(List<Order> ordersByDate) {
        for (Order order : ordersByDate) {
            io.print(order.getOrderNumber() + " | " + order.getCustomerName() + " | "
                    + io.formatCurrency(order.getTotal()));

        }
    }

    public Order getOrder () {
        Order o = new Order() {
            o.setDate(inputDate);
            o.setCustomerName(

            CustomerName());
            o.setState(

            State());
            o.setProductType(

            ProductType());
            o.setArea(

            Area());
            return o;
        
        public void displayDisplayOrder(Order o){
            io.print("Date: " + o.getDate());
            io.print("Customer: " + o.getCustomerName());
            io.print("State: " + o.getState());
            io.print("Tax Rate: " + o.getTaxRate() + "%");
            io.print("Product: " + o.getProductType());
            io.print("Material Cost per sq ft: "
                    + io.formatCurrency(o.getMaterialCostPerSquareFoot()));
            io.print("Labor Cost per sq ft: "
                    + io.formatCurrency(o.getLaborCostPerSquareFoot()));
            io.print("Area: " + o.getArea() + " sq ft");
            io.print("Material Cost: " + io.formatCurrency(o.getMaterialCost()));
            io.print("Labor Cost: " + io.formatCurrency(o.getLaborCost()));
            io.print("Tax: " + io.formatCurrency(o.getTax()));
            io.print("=== TOTAL: " + io.formatCurrency(o.getTotal()) + " ===");

        }

    public String askSave() {
            return io.readString("Do you want to save this order? Y/N",1);
    }

        public void displayAddOrderSuccess(boolean success, Order o) {
            if (success == true) {
                io.print("Order #" + o.getOrderNumber() + " was successfully added!");
            } else {
                io.print("Order was not saved.");
                displayContinue();
            }
        }

        public void displayEditOrderBanner (){
            io.print("<<< Edit Order >>>");
        }

        public int OrderNumber() {
            return io.readInt("Please enter an order number.");
        }


        public Order editOrderInfo(Order o) {
            Order editedOrder = new Order();

            io.print("Customer: " + o.getCustomerName());
            editedOrder.setCustomerName(CustomerName());

            io.print("State: " + o.getState());
            editedOrder.setState(State());

            io.print("Product: " + o.getProductType());
            editedOrder.setProductType(ProductType());

            io.print("Area: " + o.getArea() + " sq ft");
            editedOrder.setArea(Area());

            return editedOrder;
        }

        public void displayEditOrderSuccess(boolean success, Order o) {
            if (success == true) {
                io.print("Order #" + o.getOrderNumber() + " was successfully edited!");
            } else {
                io.print("Order was not edited.");
                displayContinue();
            }
        }

        public void displayRemoveOrderBanner() {
            io.print("<<< Remove Order >>>");
        }

        public String askRemove() {
            return io.readString("Would you like to remove this order? Y/N", 1);
        }

        public void displayRemoveOrderSuccess(boolean success, Order o) {
            if (success == true) {
                io.print("Order #" + o.getOrderNumber() + " was successfully removed!");
            } else {
                io.print("Order was not removed.");
                displayContinue();
            }
        }

        public void displayExitBanner() {
            io.print("Good Bye!!!");
        }

        public void displayUnknownCommandBanner() {
            io.print("Unknown Command!!!");
            displayContinue();
        }

        public void displayErrorMessage(String String errorMsg;
        errorMsg) {
            io.print("<<< Error >>>");
                String errorMsg;
                io.print(errorMsg);
            displayContinue();
        }

        public void displayContinue() {
            io.readString("Please press enter to continue.");
        }

    }

    public void displayContinue() {
    }

    public void displayExitBanner() {
    }

    public void displayUnknownCommandBanner() {
    }

    public void displayErrorMessage(String message) {
    }

    public void displayRemoveOrderSuccess(boolean b, Order o) {
    }

    public void displayEditOrderBanner() {
    }

    public int inputOrderNumber() {
    }

    public Order editOrderInfo(Order savedOrder) {
    }

    public void displayOrder(Order updatedOrder) {
    }

    public String askSave() {
    }

    public void displayEditOrderSuccess(boolean b, Order updatedOrder) {
    }

    public void displayRemoveOrderBanner() {
    }

    public String askRemove() {
    }
}




