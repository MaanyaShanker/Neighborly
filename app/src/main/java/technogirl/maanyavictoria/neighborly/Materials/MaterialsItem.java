package technogirl.maanyavictoria.neighborly.Materials;

import java.util.ArrayList;

public class MaterialsItem {
    private String header, date, description;
    public MaterialsItem() {
    }
    public MaterialsItem(String header, String date, String description) {
        this.header = header;
        this.date = date;
        this.description = description;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
