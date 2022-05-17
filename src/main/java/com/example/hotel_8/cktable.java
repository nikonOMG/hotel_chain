package com.example.hotel_8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class cktable {

    private final StringProperty id;
    private final StringProperty post;
    private final StringProperty name;
    private final StringProperty  hour;

    public cktable()
    {
        id = new SimpleStringProperty(this, "id");
        post = new SimpleStringProperty(this, "post");
        name = new SimpleStringProperty(this, "name");
        hour = new SimpleStringProperty(this, "hour");
    }

    public StringProperty idProperty() { return id; }
    public String getId() { return id.get(); }
    public void setId(String newId) { id.set(newId); }

    public StringProperty nameProperty() { return name; }
    public String getName() { return name.get(); }
    public void setName(String newName) { name.set(newName); }

    public StringProperty postProperty() { return post; }
    public String getPost() { return post.get(); }
    public void setPost(String newPost) { post.set(newPost); }

    public StringProperty hourProperty() { return hour; }
    public String getHour() { return hour.get(); }
    public void setHour(String newHour) { hour.set(newHour); }

}
