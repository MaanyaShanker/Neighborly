package technogirl.maanyavictoria.neighborly.Money;

public class MoneyItem {
    private String header, date, short_description, long_description;
    private int progress, max;

    public MoneyItem(String header, String date, String short_description, String long_description, int progress, int max) {
        this.header = header;
        this.date = date;
        this.short_description = short_description;
        this.long_description = long_description;
        this.progress = progress;
        this.max = max;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
