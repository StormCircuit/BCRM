package desktopUI;

import hibernate.entity.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerTableDataClass extends Customer{
    private final StringProperty columnName = new SimpleStringProperty();
    private final StringProperty columnRevenue = new SimpleStringProperty();

    public CustomerTableDataClass(String name, double revenue) {
        columnName.set(String.valueOf(name));
        columnRevenue.set(String.valueOf(revenue));
    }

    /*
    public StringProperty ActivityName = String.valueOf(getName());
    public StringProperty ActivityPrice = String.valueOf(getPrice());
    */

    public StringProperty columnNameProperty(){
        return columnName;
    }

    public StringProperty columnRevenueProperty(){
        return columnRevenue;
    }

    /*
    public void setColumnName() {
        columnName.set(getName());
    }

    public void setColumnPrice() {
        columnPrice.set(String.valueOf(getPrice()));
    }
    */

}