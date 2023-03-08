package dao;

import dto.Order;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

public class FlooringDaoFileImpl implements OrdersDao {

    private int lastOrderNumber;
    private static final String HEADER = "OrderNumber,CustomerName, State, TaxRate."
            + "ProductType,Area,CostPerSquareFoot,LabourCostPerSquareFoot,"
            + "MaterialCost,LabourCost,Tax,Total ";
    private static final String DELIMITER = ",";
    private String dataFolder = "orders/";

    public FlooringDaoFileImpl(){

    }

    public FlooringDaoFileImpl(String dataFolder) {
        this.dataFolder = dataFolder;
    }

    private void readLastOrderNumber() throws DataDaoException {
        Scanner scanner;

        try {
            //create scanner to read file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(dataFolder + "LastOrderNumber.txt")));
            {
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(" Error, could not upload order number into memory", e);
        }

        int savedOrderNumber = Integer.parseInt(scanner.nextLine());
        this.lastOrderNumber = savedOrderNumber;
        scanner.close();

        int lastOrderNumber1 = lastOrderNumber;
    }
        private void writeLastOrderNumber (int lastOrderNumber) throws DataDaoException {
                PrintWriter out;

                try {
                    out = new PrintWriter(new FileWriter(dataFolder + "LastOrderNumber.txt"));

                } catch (IOException e) {
                    throw  new DataDaoException(
                            "Could not save order number", e);

                }

                out.println(lastOrderNumber);
                out.flush();
                out.close();

            }



    @Override
    public Order editOrder(Order editedOrder) throws DataDaoException {
        return null;
    }

    @Override
    public Order removedOrder(Order order) throws DataDaoException {
        return null;
    }
}
