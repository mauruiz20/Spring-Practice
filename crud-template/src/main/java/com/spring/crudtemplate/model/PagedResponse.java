package com.spring.crudtemplate.model;

import java.util.List;

public class PagedResponse<T> {

    private int numRows;

    private List<T> results;

    public PagedResponse() {

    }

    public PagedResponse(int numRows, List<T> results) {
        this.numRows = numRows;
        this.results = results;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
}
