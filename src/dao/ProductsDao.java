package dao;

import dto.Product;

public interface ProductsDao {

    Product getProduct(String productType) throws DataDaoException;
}
