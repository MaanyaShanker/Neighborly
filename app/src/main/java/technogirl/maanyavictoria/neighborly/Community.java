package technogirl.maanyavictoria.neighborly;

import java.util.ArrayList;

import technogirl.maanyavictoria.neighborly.Materials.MaterialsItem;
import technogirl.maanyavictoria.neighborly.Money.MoneyItem;
import technogirl.maanyavictoria.neighborly.Time.TimeItem;

public class Community {
    ArrayList<MaterialsItem> materialsItem;
    ArrayList<MoneyItem> moneyItem;
    ArrayList<TimeItem> timeItem;
    User user;
    public Community() {
        this.materialsItem = new ArrayList<>();
        this.moneyItem = new ArrayList<>();
        this.timeItem = new ArrayList<>();
    }

    public Community(User user) {
        this.materialsItem = new ArrayList<>();
        this.moneyItem = new ArrayList<>();
        this.timeItem = new ArrayList<>();
        this.user = user;
    }

    public Community(ArrayList<MaterialsItem> materialsItem, ArrayList<MoneyItem> moneyItem, ArrayList<TimeItem> timeItem, User user) {
        this.materialsItem = materialsItem;
        this.moneyItem = moneyItem;
        this.timeItem = timeItem;
        this.user = user;
    }

    public ArrayList<MaterialsItem> getMaterialsItem() {
        return materialsItem;
    }

    public void setMaterialsItem(ArrayList<MaterialsItem> materialsItem) {
        this.materialsItem = materialsItem;
    }

    public ArrayList<MoneyItem> getMoneyItem() {
        return moneyItem;
    }

    public void setMoneyItem(ArrayList<MoneyItem> moneyItem) {
        this.moneyItem = moneyItem;
    }

    public ArrayList<TimeItem> getTimeItem() {
        return timeItem;
    }

    public void setTimeItem(ArrayList<TimeItem> timeItem) {
        this.timeItem = timeItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
