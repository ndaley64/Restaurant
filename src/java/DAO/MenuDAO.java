/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import db.accessor.DBAccessor;
import db.accessor.DB_MySql;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ndaley
 */
public class MenuDAO implements DAO{
    DBAccessor dba = new DB_MySql();
    
    @Override
    public List<MenuItem> getAllMenuItems(){
        List<MenuItem> MenuItems = new ArrayList();
        List<Map> Menu = null;
        List<String> colNames = new ArrayList();
        colNames.add("*");
        
        try{
             Menu = dba.getRecords("menu", colNames);
        }catch(SQLException sql){
            System.err.println("SQL Exception");
        }catch(Exception e){
            System.err.println("Exception");
        }
        
        for(Map m : Menu){
            MenuItem mi = new MenuItem(m.get("item_id").toString(), m.get("item_name").toString(),
                                        m.get("item_price").toString());
            MenuItems.add(mi);
        }
        
        return MenuItems;
    }
    
    public static void main(String[] args) {
        DAO dao = new MenuDAO();
        
        List<MenuItem> MenuItems = dao.getAllMenuItems();
        
        for(MenuItem mi : MenuItems){
            System.out.println(mi.toString());
        }
    }
    
}
