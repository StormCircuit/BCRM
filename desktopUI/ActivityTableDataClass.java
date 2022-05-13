package desktopUI;

import hibernate.entity.Activity;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActivityTableDataClass extends Activity{
    private final StringProperty columnName = new SimpleStringProperty();
    private final StringProperty columnPrice = new SimpleStringProperty();
    private int ID;

    public ActivityTableDataClass(String name, double price) {
        super(name, price);
        columnName.set(String.valueOf(getName()));
        columnPrice.set(String.valueOf(getPrice()));
    }
    
    public ActivityTableDataClass(String name, double price, int idArg){
        super(name, price);
        columnName.set(String.valueOf(getName()));
        columnPrice.set(String.valueOf(getPrice()));
        setId(idArg);
    }

    /*
    public StringProperty ActivityName = String.valueOf(getName());
    public StringProperty ActivityPrice = String.valueOf(getPrice());
    */

    public StringProperty columnNameProperty(){
        columnName.set(String.valueOf(getName()));
        return columnName;
    }

    public StringProperty columnPriceProperty(){
        columnPrice.set(String.valueOf(getPrice()));
        return columnPrice;
    }

    public Integer IDProperty(){
        return ID;
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