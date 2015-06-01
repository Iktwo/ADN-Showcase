package com.iktwo.showcase;

public class AppInfo {
    private String title;
    private String description;
    private String packageName;

    public AppInfo(String title, String description, String packageName) {
        this.title = title;
        this.description = description;
        this.packageName = packageName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
