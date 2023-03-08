package Service;

import dao.DataDaoException;
import dto.Order;

import java.time.LocalDate;
import java.util.List;

public interface FloorService {

    List<Order> getOrders(LocalDate dateChoice) throws InvalidOrderNumberException,
            DataDaoException;

    Order calculateOrder(Order o) throws DataDaoException,
            OrderValidationException, StateValidationException, ProductValidationException;

    Order getOrder(LocalDate dateChoice, int orderNumber) throws
            DataDaoException, InvalidOrderNumberException;

    Order addOrder(Order o) throws DataDaoException;

    Order compareOrders(Order savedOrder, Order editedOrder)
            throws DataDaoException, StateValidationException,
            ProductValidationException;

    Order editOrder(Order updatedOrder) throws DataDaoException,
            InvalidOrderNumberException;

    Order removeOrder(Order removedOrder) throws DataDaoException,
            InvalidOrderNumberException;
}
