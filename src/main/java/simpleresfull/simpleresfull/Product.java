/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleresfull.simpleresfull;

/**
 *
 * @author MSI 65 SERIES
 */
public class Product {

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }
    
    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
    private String Id;
    private String Name;
    private String Quantity;
    private String  Price;
    
}