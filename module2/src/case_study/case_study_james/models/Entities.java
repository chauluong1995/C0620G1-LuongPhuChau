package case_study.case_study_james.models;

public class Entities {
    private String keyword;
    private String type;
    private String mean;

    public Entities() {
    }

    public Entities(String type, String mean) {
        this.type = type;
        this.mean = mean;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String showInfo(){
        return "Type : " + type + " , mean : " + mean;
    }

    @Override
    public String toString() {
        return type + "," + mean;
    }
}
