package com.github.pbetkier.spockdemo;

import java.util.Date;
import java.util.List;

public interface DataProvider {

    List<String> data();

    List<String> pagedData(Integer page, Integer pageSize);

    Integer size();

    Date updatedAt();

    Person responsible();

    String id();
}
