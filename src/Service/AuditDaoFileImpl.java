package Service;

import dao.DataDaoException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AuditDaoFileImpl implements AuditDao {

    public static final String AUDIT_FILE = "Audit.txt";
    @Override
    public void writeAuditEntry(String entry) throws DataDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE,true));
        } catch (IOException e) {
            throw new DataDaoException("Could not get audit information");
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
}
