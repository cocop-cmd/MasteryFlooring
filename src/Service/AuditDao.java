package Service;

import dao.DataDaoException;

public interface AuditDao {
    public void writeAuditEntry(String entry) throws DataDaoException;
}
