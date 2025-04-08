package com.yesterdaysnews.yesterdaysnews.model;

public class Category {
    private int id;
    private String type;

        // Plantilla - a adaptar a las necesidades del proyecto
        public Category(int id, String type){
            this.id = id;
            this.type = type;
        }

public Category(){
    
}
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
