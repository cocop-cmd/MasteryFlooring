package FlooringMast.controller;

import Flooringmastery.ui.FlooringView;
import Service.*;
import dao.DataDaoException;
import dao.DataDaoException;
import dto.Order;
import javax.swing.text.View;
import java.time.LocalDate;
import java.util.List;



public class FlooringController {

    FloorService service;
    FlooringView view;

    public FlooringController(FloorService service, FlooringView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {


                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        createOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        exportsAllData();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DataDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void createOrder() {
    }

    private void displayOrders() {
    }

    private void exportsAllData() {
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void getOrdersByDate() throws DataDaoException {
        LocalDate dateChoice = view.inputDate();
        view.displayDateBanner(dateChoice);
        try {
            view.displayDateOrders(service.getOrders(dateChoice));
            view.displayContinue();
        } catch (InvalidOrderNumberException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void editOrder() throws DataDaoException {
        view.displayEditOrderBanner();
        try {
            LocalDate dateChoice = view.inputDate();
            int orderNumber = view.inputOrderNumber();
            Order savedOrder = service.getOrder(dateChoice, orderNumber);
            Order editedOrder = view.editOrderInfo(savedOrder);
            Order updatedOrder = service.compareOrders(savedOrder, editedOrder);
            view.displayEditOrderBanner();
            view.displayOrder(updatedOrder);
            String response = view.askSave();
            if (response.equalsIgnoreCase("Y")) {
                service.editOrder(updatedOrder);
                view.displayEditOrderSuccess(true, updatedOrder);
            } else if (response.equalsIgnoreCase("N")) {
                view.displayEditOrderSuccess(false, updatedOrder);
            } else {
                unknownCommand();
            }
        } catch (InvalidOrderNumberException
                 | ProductValidationException | StateValidationException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void removeOrder() throws DataDaoException {
        view.displayRemoveOrderBanner();
        LocalDate dateChoice = view.inputDate();
        view.displayDateBanner(dateChoice);
        try {
            view.displayDateOrders(service.getOrders(dateChoice));
            int orderNumber = view.inputOrderNumber();
            Order o = service.getOrder(dateChoice, orderNumber);
            view.displayRemoveOrderBanner();
            view.displayOrder(o);
            String response = view.askRemove();
            if (response.equalsIgnoreCase("Y")) {
                service.removeOrder(o);
                view.displayRemoveOrderSuccess(true, o);
            } else if (response.equalsIgnoreCase("N")) {
                view.displayRemoveOrderSuccess(false, o);
            } else {
                unknownCommand();
            }
        } catch (InvalidOrderNumberException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}



