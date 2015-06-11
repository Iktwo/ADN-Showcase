package com.iktwo.showcase;

public class AppInfo {
    private String title;
    private String description;
    private String packageName;
    private boolean inStore;

    public AppInfo(String title, String description, String packageName, boolean inStore) {
        this.title = title;
        this.description = description;
        this.packageName = packageName;
        this.inStore = inStore;
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

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }
}
