package com.example.pethospital.service;

import com.example.pethospital.pojo.TestItem;

import java.util.List;

public interface TestItemService {
    void addTestItem(TestItem testItem);

    List<TestItem> selectAllTestItem();

    int selectTestItemCount();

    void deleteTestItemById(int testItemId);

    void updateTestItem(TestItem testItem);

    List<TestItem> getTestItemsByName(String testItemName);

    TestItem selectById(int testItemId);
}
