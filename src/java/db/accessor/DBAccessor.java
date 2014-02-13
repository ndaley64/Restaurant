package db.accessor;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ndaley
 */
public interface DBAccessor {
    public List<Map> getRecords(String tableName, List<String> columnNames)
    throws SQLException, Exception ;
}
