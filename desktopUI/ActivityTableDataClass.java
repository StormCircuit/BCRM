package desktopUI;

import hibernate.entity.Activity;
import javafx.beans.property.StringProperty;

class ActivityTableDataClass extends Activity{
    public ActivityTableDataClass(String name, double price) {
        super(name, price);
    }

    private StringProperty activityName;
    private StringProperty activityPrice;

    public String getActivityNameProperty(){
        activityName.set(getName());
        return activityName.get();
    }

    public String getActivityPriceProperty(){
        activityPrice.set(String.valueOf(getPrice()));
        return activityPrice.get();
    }

    /*
    public void setActivityName(String name) {
        
    }

    public void setActivityPrice(String string) {
    }
    */

}