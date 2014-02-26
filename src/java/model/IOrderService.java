package model;

import DAO.MenuItem;
import java.util.List;

/**
 *
 * @author Nathaniel
 */
public interface IOrderService {
    public void setDaoFromString(String dao) throws Exception;
    
    public List<MenuItem> getAllMenuItems();
}
