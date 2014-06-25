package com.github.pbetkier.spockdemo;

import java.util.Date;
import java.util.List;

public interface DataProvider {

    List<String> data();

    Integer size();

    Date updatedAt();

    Person responsible();
}
