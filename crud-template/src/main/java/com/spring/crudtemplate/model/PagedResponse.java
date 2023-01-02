package com.spring.crudtemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

public class PagedResponse<T> {

    private int page;
    private boolean last;
    private int numRows;
    private List<T> result;
}
