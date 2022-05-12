package desktopUI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HistoricalPricesTableDataClass{
    private final StringProperty columnName = new SimpleStringProperty();
    private final StringProperty columnDate = new SimpleStringProperty();

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