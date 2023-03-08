package dao;

import dto.State;

import java.util.List;

public interface StatesDao {


    State getState(String state) throws DataDaoException;
}