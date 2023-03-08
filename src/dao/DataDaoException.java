package dao;

public class DataDaoException extends Exception{

    public DataDaoException(String message) {
        super(message);
    }

    public DataDaoException (String message, Throwable cause) {
        super (message, cause);
    }
}
