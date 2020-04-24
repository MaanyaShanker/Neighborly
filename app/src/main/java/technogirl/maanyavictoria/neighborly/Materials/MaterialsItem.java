package technogirl.maanyavictoria.neighborly.Materials;


public class MaterialsItem {
    private String header, date, short_description, long_description;
    public MaterialsItem() {
    }

    public MaterialsItem(String header, String date, String short_description, String long_description) {
        this.header = header;
        this.date = date;
        this.short_description = short_description;
        this.long_description = long_description;
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

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }
}
