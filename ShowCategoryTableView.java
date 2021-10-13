package ku.cs.controllers.admin;

import javafx.beans.property.SimpleStringProperty;

public class ShowCategoryTableView {
    private SimpleStringProperty CategoryDataName;
    private SimpleStringProperty CategoryData1;
    private SimpleStringProperty CategoryData2;

    public ShowCategoryTableView(String categoryDataName, String categoryData1, String categoryData2) {
        CategoryDataName = new SimpleStringProperty(categoryDataName);
        CategoryData1 = new SimpleStringProperty(categoryData1);
        CategoryData2 = new SimpleStringProperty(categoryData2);
    }

    public String getCategoryDataName() {
        return CategoryDataName.get();
    }

    public void setCategoryDataName(String categoryDataName) {
        CategoryDataName = new SimpleStringProperty(categoryDataName);
    }

    public String getCategoryData1() {
        return CategoryData1.get();
    }

    public void setCategoryData1(String categoryData1) {
        CategoryData1 = new SimpleStringProperty(categoryData1);
    }

    public String getCategoryData2() {
        return CategoryData2.get();
    }

    public void setCategoryData2(String categoryData2) {
        CategoryData2 = new SimpleStringProperty(categoryData2);
    }
}
