package case_study.case_study_james.models;

import case_study.case_study_james.commons.Service;

import java.util.ArrayList;
import java.util.List;

public class Request {
    private String action;
    private List<String> params = new ArrayList<>();
    private String keyword;

    public Request() {
    }

    public Request(String action, List<String> params, String keyword) {
        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public void checkAction() {
        switch (this.action) {
            case "lookup":
                Service.lookup(this.keyword);
                break;
            case "define":
                Service.define(this.params, this.keyword);
                break;
            case "drop":
                Service.drop(this.keyword);
                break;
            default:
                Service.export(this.keyword);
                break;
        }
    }
}
