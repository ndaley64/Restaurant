/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.DAO;
import DAO.MenuDAO;
import DAO.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathaniel
 */
public class OrderService implements IOrderService{
    DAO dao;
    private List<MenuItem> menuList;
    private List<MenuItem> orderList;

    public OrderService(String dao) {
        try {
            setDaoFromString(dao);
        } catch (Exception ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
    
    public List<MenuItem> getAllMenuItems(){
        DAO dao = new MenuDAO();
        
        List<MenuItem> MenuItems = dao.getAllMenuItems();
        
        return MenuItems;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public List<MenuItem> getOrderList() {
        if(this.orderList == null){
            this.orderList = new ArrayList<MenuItem>();
        }
        return orderList;
    }

    public void setOrderList(List<MenuItem> orderList) {
        this.orderList = orderList;
    }
    
//    public static void main(String[] args) {
//        OrderService os = new OrderService(new MenuDAO());
//        
//        List<MenuItem> menuItems = os.getAllMenuItems();
//        
//        for(MenuItem mi : menuItems){
//            System.out.println(mi.toString());
//        }
//    }

    public void setDaoFromString(String dao) throws Exception{
        Class clazz = Class.forName(dao);
        this.dao = (DAO)clazz.newInstance();
    }

    @Override
    public String toString() {
        return "OrderService{" + '}';
    }
}
