////CIS 230, Dr. Peng, Spring 2023. Capstone project by Ryan Thornton shoppingCartClass and Item class.
import java.text.DecimalFormat;
import java.util.ArrayList;

//Creating the class and initalizing private stuff. 
public class shoppingCart {
    //Using an array list of the String type to hold the product info to print later
    private ArrayList<String> products = new ArrayList<String>();
    //An ArrayList of the class object "Item" to store the items. This helps us in the remove item method
    private ArrayList<Item> m_rgItems = new ArrayList<Item>();
    //ArrayList that holds prices. The prices index align with the item it is associated with, so we can reduce the price when an item is removed
    private ArrayList<Double> prices = new ArrayList<Double>();
    private int m_iNumOfItems = 0;
    private double total = 0;
    //Deciaml format just to make the print outs nicer :)
    private DecimalFormat rounder = new DecimalFormat("##.##");


    public shoppingCart() {
    }

    public ArrayList<String> getProductList(){
        return products;
    }
    public ArrayList<Double> getPrices(){
        return prices;
    }
    //Remove item for extra credit!
    public void removeItem(ArrayList<Item> item, int index){
        item.remove(index);

    }

    public ArrayList<Item> getM_rgItems() {
        return this.m_rgItems;
    }

    public int getNumItems(){
        return m_iNumOfItems;
    }
    //Ensures price is right if we remove an item!
    public void reduceToatl(ArrayList<Double> prices, int p){
        total -= prices.get(p);
    }



    public void addItem(String name, String description, double price, int units){
        Item item = new Item();
        item.setM_sProductName(name);
        item.setM_sProductDescription(description);
        item.setM_dUnitPrice(price);
        item.setM_nUnits(units);
        m_rgItems.add(item);
        products.add(item.getM_sProductName());
        prices.add(item.getM_dUnitPrice()* units);
        m_iNumOfItems++;
        total += item.calculateUnitTotal(price, units);
        
    }

    public double getTotal(){
        return total;
    }




    class Item {
        private String m_sProductName = "";
        private String m_sProductDescription = "";
        private double m_dUnitPrice = -1;
        private int m_nUnits = -1;
    
    
    
        public Item() {
        }
    
        public String getM_sProductName() {
            return this.m_sProductName;
        }
    
        public void setM_sProductName(String m_sProductName) {
            this.m_sProductName = m_sProductName;
        }
    
        public String getM_sProductDescription() {
            return this.m_sProductDescription;
        }
    
        public void setM_sProductDescription(String m_sProductDescription) {
            this.m_sProductDescription = m_sProductDescription;
        }
    
        public double getM_dUnitPrice() {
            return Double.parseDouble(rounder.format(this.m_dUnitPrice));
        }
    
        public void setM_dUnitPrice(double m_dUnitPrice) {
            this.m_dUnitPrice = m_dUnitPrice;
        }
    
        public int getM_nUnits() {
            return this.m_nUnits;
        }
    
        public void setM_nUnits(int m_nUnits) {
            this.m_nUnits = m_nUnits;
        }
    
        public double calculateUnitTotal(double price, int units){
            double unitTotal = price * units;
            return Double.parseDouble(rounder.format(unitTotal));
        }
        
    
        public String toString() {
            return
                "Product name: " + getM_sProductName() + "\n" +
                "Product description: " + getM_sProductDescription() + "\n" +
                "Unit price: $" + getM_dUnitPrice() + "\n" +
                "Number of units: " + getM_nUnits() + "\n" +
                "Total price of all units: $" + calculateUnitTotal(getM_dUnitPrice(), getM_nUnits());
        }
    
    }
    

}

