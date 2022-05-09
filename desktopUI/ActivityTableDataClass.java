package desktopUI;

import hibernate.entity.Activity;
import javafx.beans.property.StringProperty;

class ActivityTableDataClass extends Activity{
    public ActivityTableDataClass(String name, double price) {
        super(name, price);
    }

    public String ActivityName = String.valueOf(getName());
    public String ActivityPrice = String.valueOf(getPrice());

    public String getActivityName(){
        ActivityName = String.valueOf(getName());
        return ActivityName;
    }

    public String getActivityPrice(){
        ActivityPrice = String.valueOf(getName());
        return ActivityPrice;
    }

    /*
    public void setActivityName(String name) {
        
    }

    public void setActivityPrice(String string) {
    }
    */

}