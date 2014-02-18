/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Objects;

/**
 *
 * @author ndaley
 */
public class MenuItem {
    private String item_id;
    private String item_name;
    private String item_price;

    public MenuItem() {
    }

    public MenuItem(String item_id, String item_name, String item_price) {
        this.setItemID(item_id);
        this.setItemName(item_name);
        this.setItemPrice(item_price);
    }

    public String getItemID() {
        return item_id;
    }

    public void setItemID(String item_id) {
        this.item_id = item_id;
    }

    public String getItemName() {
        return item_name;
    }

    public void setItemName(String item_name) {
        this.item_name = item_name;
    }

    public String getItemPrice() {
        return item_price;
    }

    public void setItemPrice(String item_price) {
        this.item_price = item_price;
    }

    @Override
    public String toString() {
        return item_id + "/" + item_name + "/" + item_price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.item_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (!Objects.equals(this.item_id, other.item_id)) {
            return false;
        }
        return true;
    }
    
    
}
