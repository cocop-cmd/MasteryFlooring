package dao;

import dto.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrdersDao {

    List<Order> getOrders(LocalDate dateChoice) throws DataDaoException;

    Order addOrder(Order order) throws DataDaoException;

    Order editOrder(Order editedOrder) throws DataDaoException;

    Order removedOrder(Order order) throws DataDaoException;

}
