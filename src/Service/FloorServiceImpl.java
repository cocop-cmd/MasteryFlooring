package Service;

import Service.*;
import dao.DataDaoException;
import dao.OrdersDao;
import dao.ProductsDao;
import dao.StatesDao;
import dto.Order;
import dto.Product;
import dto.State;

import javax.management.remote.JMXServerErrorException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FloorServiceImpl implements FloorService {


    private OrdersDao ordersDao;
    private ProductsDao productsDao;
    private StatesDao statesDao;

    public FloorServiceImpl(OrdersDao ordersDao, ProductsDao productsDao,
                            StatesDao statesDao) {
        this.ordersDao = ordersDao;
        this.productsDao = productsDao;
        this.statesDao = statesDao;
    }

    @Override
    public List<Order> getOrders(LocalDate dateChoice) throws InvalidOrderNumberException, DataDaoException {
        List<Order> ordersByDate = ordersDao.getOrders(dateChoice);
        if (!ordersByDate.isEmpty()) {
            return ordersByDate;
        } else {
            throw new InvalidOrderNumberException("ERROR: No orders exists on that date");
        }
    }

    @Override
    public Order calculateOrder(Order o) throws DataDaoException, OrderValidationException, StateValidationException, ProductValidationException {

        validateOrder(o);
        calculateTax(o);
        calculateMaterial(o);
        calculateTotal(o);

        return o;
    }

    private void calculateTax (Order o) throws DataDaoException,
            StateValidationException{
        State chosenState = statesDao.getState(o.getState());
        if (chosenState == null) {
            throw new StateValidationException("Error: Does not" + "serve state");
        }

        o.setState(chosenState.getState());
        o.setTaxRate(chosenState.getTaxRate());
}

    private void calculateMaterial(Order o) throws DataDaoException,
    ProductValidationException {
        Product chosenProduct = productsDao.getProduct(o.getProductType());
        if (chosenProduct == null) {
            throw new ProductValidationException("ERROR: We do not sell that" +
                    "product");
        }

        o.setProductType(chosenProduct.getProductType());
        o.setMaterialCostPerSquareFoot(chosenProduct.getMaterialCostPerSquareFoot());
        o.setLabourCostPerSquareFoot(chosenProduct.getLabourCostPerSquareFoot());
    }

    private void calculateTotal(Order o) {
        // calculates order fields
        o.setMaterialCost(o.getMaterialCostPerSquareFoot().multiply(o.getArea())
                .setScale(2, RoundingMode.HALF_UP));
        o.setLabourCost(o.getLaborCostPerSquareFoot().multiply(o.getArea())
                .setScale(2, RoundingMode.HALF_UP));
        o.setTax(o.getTaxRate().divide(new BigDecimal("100.00"))
                .multiply((o.getMaterialCost().add(o.getLaborCost())))
                .setScale(2, RoundingMode.HALF_UP));
        o.setTotal(o.getMaterialCost().add(o.getLaborCost()).add(o.getTax()));
    }

    private void validateOrder(Order o) throws OrderValidationException {
        String message = "";
        if (o.getCustomerName().trim().isEmpty() ||o.getCustomerName() == null) {
            message += "Customer name is require.\n";
        }
        if (o.getState().trim().isEmpty() || o.getState() == null) {
            message += "State is required.\n";
        }
        if (o.getProductType().trim().isEmpty() || o.getProductType() == null) {
            message += "Product type is required.\n";
        }
        if (o.getArea().compareTo(BigDecimal.ZERO) == 0 || o.getArea() == null) {
            message += " Area square footage is required";
        }
        if (!message.isEmpty()) {
            throw new OrderValidationException(message);
        }
    }

    @Override
    public Order getOrder(LocalDate dateChoice, int orderNumber) throws DataDaoException, InvalidOrderNumberException {
        List<Order> orders = getOrders(dateChoice);
        Order chosenOrder = orders.stream()
                .filter(o-> o.getOrderNumber() == orderNumber)
                .findFirst().orElse(null);
        if (chosenOrder !=null) {
            return chosenOrder;
        } else {
            throw new InvalidOrderNumberException("ERROR No orders with that number" +"exists on that date");
        }

    }

    @Override
    public Order addOrder(Order o) throws DataDaoException {
        ordersDao.addOrder(o);

        return null;
    }

    @Override
    public Order compareOrders(Order savedOrder, Order editedOrder) throws DataDaoException, StateValidationException, ProductValidationException {
        if (editedOrder.getCustomerName() == null
                || editedOrder.getCustomerName().trim().equals("")) {

        } else {
            savedOrder.setCustomerName(editedOrder.getCustomerName());
        }

        if (editedOrder.getState() == null
                || editedOrder.getState().trim().equals("")) {

        } else {
            savedOrder.setState(editedOrder.getState());
            calculateTax(savedOrder);
        }

        if (editedOrder.getProductType() == null
                || editedOrder.getProductType().equals("")) {
        } else {
            savedOrder.setProductType(editedOrder.getProductType());
            calculateMaterial(savedOrder);
        }

        if (editedOrder.getArea() == null
                || (editedOrder.getArea().compareTo(BigDecimal.ZERO)) == 0) {
        } else {
            savedOrder.setArea(editedOrder.getArea());
        }

        calculateTotal(savedOrder);

        return savedOrder;
    }



    @Override
    public Order editOrder(Order updatedOrder) throws DataDaoException, InvalidOrderNumberException {
         updatedOrder = ordersDao.editOrder(updatedOrder);
         if (updatedOrder != null) {
             auditDao.writeAuditEntry("Order #" +
                    updatedOrder.getOrderNumber() + " for date"
             + updatedOrder.getDate() + "EDITED");
             return updatedOrder;
         } else {
             throw new InvalidOrderNumberException("Error: No orders with that number" +
                     "exist on that date");
         }
    }

    @Override
    public Order removeOrder(Order removedOrder) throws DataDaoException, InvalidOrderNumberException {
        removedOrder = ordersDao.removedOrder(removedOrder);
        if (removedOrder != null) {
            auditDao.writeAuditEntry("Order #" +
                    +removedOrder.getOrderNumber() + "for date"
                    + removedOrder.getDate() + " REMOVED");
            return removedOrder;
        } else {
            throw new InvalidOrderNumberException("ERROR No order with that number" +" exist on that date");
        }
    }
}
