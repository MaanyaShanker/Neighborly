package technogirl.maanyavictoria.neighborly;

import java.sql.Time;

import technogirl.maanyavictoria.neighborly.Materials.MaterialsItem;
import technogirl.maanyavictoria.neighborly.Money.MoneyItem;
import technogirl.maanyavictoria.neighborly.Time.TimeItem;

public class User {
    String name, email, phone_number, community;
    Boolean head, last_minute;
    MaterialsItem materialsItem;
    MoneyItem moneyItem;
    TimeItem timeItem;

    public User() {
    }

    public User(String name, String email, String phone_number, String community, Boolean head, Boolean last_minute) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.community = community;
        this.head = head;
        this.last_minute = last_minute;
    }

    public User(String name, String email, String phone_number) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Boolean getHead() {
        return head;
    }

    public void setHead(Boolean head) {
        this.head = head;
    }

    public Boolean getLast_minute() {
        return last_minute;
    }

    public void setLast_minute(Boolean last_minute) {
        this.last_minute = last_minute;
    }
    public MaterialsItem getMaterialsItem() {
        return materialsItem;
    }

    public void setMaterialsItem(MaterialsItem materialsItem) {
        this.materialsItem = materialsItem;
    }

    public MoneyItem getMoneyItem() {
        return moneyItem;
    }

    public void setMoneyItem(MoneyItem moneyItem) {
        this.moneyItem = moneyItem;
    }

    public TimeItem getTimeItem() {
        return timeItem;
    }

    public void setTimeItem(TimeItem timeItem) {
        this.timeItem = timeItem;
    }

}
