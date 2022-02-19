package com.pl1111w.jdbc.ConnectonDatabasePool;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/2/19 14:24
 */
public class Goods {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
