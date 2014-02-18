/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.DAO;
import DAO.MenuDAO;
import DAO.MenuItem;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Nathaniel
 */
public class OrderService {
    private Calendar now = Calendar.getInstance();
    private String currentTimePeriod;
    
    public String getCurrentTimePeriod(){
        now = Calendar.getInstance();
        int currentHour = now.get(Calendar.HOUR_OF_DAY);
        
        if(currentHour < 12){
            currentTimePeriod = "morning";
        }else if(currentHour >= 12 && currentHour < 18){
            currentTimePeriod = "afternoon";
        }else{
            currentTimePeriod = "evening";
        }

        return currentTimePeriod;
    }
    
    public String getWelcomeMessage(String name){
        String welcomeMessage = "Good " + this.getCurrentTimePeriod() + ", " + name + ". Welcome!";
        
        return welcomeMessage;
    }
    
    public List<MenuItem> getAllMenuItems(){
        DAO dao = new MenuDAO();
        
        List<MenuItem> MenuItems = dao.getAllMenuItems();
        
        return MenuItems;
    }
    
    public static void main(String[] args) {
        OrderService os = new OrderService();
        
        List<MenuItem> menuItems = os.getAllMenuItems();
        
        for(MenuItem mi : menuItems){
            System.out.println(mi.toString());
        }
    }
}
