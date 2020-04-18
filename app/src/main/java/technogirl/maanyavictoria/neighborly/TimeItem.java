package technogirl.maanyavictoria.neighborly;

import java.util.ArrayList;

public class TimeItem {
    private ArrayList<String> header, date, description;

    public TimeItem() {
    }

    public TimeItem(ArrayList<String> header, ArrayList<String> date, ArrayList<String> description) {
        this.header = header;
        this.date = date;
        this.description = description;
    }

    public ArrayList<String> getHeader() {
        return header;
    }

    public void setHeader(ArrayList<String> header) {
        this.header = header;
    }

    public ArrayList<String> getDate() {
        return date;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }
}
