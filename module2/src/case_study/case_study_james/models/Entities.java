package case_study.case_study_james.models;

import java.io.Serializable;

public class Entities implements Serializable {
    private String type;
    private String keyword;
    private String mean;

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

    @Override
    public String toString() {
        return keyword + " = type : " + type + " , mean : " + mean;
    }
}
