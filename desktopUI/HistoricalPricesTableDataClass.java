package desktopUI;

import java.util.ArrayList;
import java.util.List;

import hibernate.entity.Price;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HistoricalPricesTableDataClass{
    private StringProperty price = new SimpleStringProperty();
    private StringProperty date = new SimpleStringProperty();

    public HistoricalPricesTableDataClass(String priceArg, String dateArg){
        this.price.set(priceArg);
        this.date.set(dateArg);
    }

    public StringProperty columnPriceProperty(){
        return price;
    }

    public StringProperty columnDateProperty(){
        return date;
    }

}