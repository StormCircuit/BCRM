package desktopUI;

import java.util.ArrayList;
import java.util.List;

import hibernate.entity.Price;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HistoricalPricesTableDataClass{
    private final StringProperty columnName = new SimpleStringProperty();
    private List<Price> historicalPriceList = new ArrayList<Price>();

    public HistoricalPricesTableDataClass(String price, String dateChanged) {
        columnName.set(String.valueOf(price));
        columnDate.set(String.valueOf(dateChanged));
    }

    /*
    public StringProperty ActivityName = String.valueOf(getName());
    public StringProperty ActivityPrice = String.valueOf(getPrice());
    */

    public StringProperty columnNameProperty(){
        return columnName;
    }

    public StringProperty columnDateProperty(){
        return columnDate;
    }

}