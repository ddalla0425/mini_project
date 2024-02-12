package com.common;

public class SearchCondition {
    private String searchOption;
    private String searchValue;

    public SearchCondition() {
    }

    public SearchCondition(String searchOption, String searchValue) {
        this.searchOption = searchOption;
        this.searchValue = searchValue;
    }

    public String getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(String searchOption) {
        this.searchOption = searchOption;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "searchOption='" + searchOption + '\'' +
                ", searchValue='" + searchValue + '\'' +
                '}';
    }

}
//SerchCondition