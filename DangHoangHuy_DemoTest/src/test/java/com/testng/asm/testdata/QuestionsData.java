package com.testng.asm.testdata;

import com.testng.asm.helpers.ExcelHelper;
import com.testng.asm.helpers.JsonHelper;
import org.testng.annotations.DataProvider;

public class QuestionsData {
    @DataProvider
    public static Object[][] getQuestionsJsonData(){
        return JsonHelper.readOrderListFromJsonFile("src/test/resources/questions.json");
    }

    @DataProvider
    public static Object[][] getQuestionsExcelData(){
        return ExcelHelper.readOrderListFromExcelFile("src/test/resources/questions.xlsx");
    }
}