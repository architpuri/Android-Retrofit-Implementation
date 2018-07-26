package demoapps.com.dummyapi;

import java.util.ArrayList;

public class listData {
private String txtRow;
private boolean checker;

public listData(String s,Boolean b){
    this.txtRow=s;
    this.checker=b;
}
public String getRowText(){
    return txtRow;
}
public boolean getCheckState(){
    return checker;
}
    private static int lastItemid = 0;

    public static ArrayList<listData> createItemList(int itemNos) {
        ArrayList<listData> items = new ArrayList<listData>();

        for (int i = 1; i <= itemNos; i++) {
            items.add(new listData("Item " + ++lastItemid,true));
        }

        return items;
    }

}
