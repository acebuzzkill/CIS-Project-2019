package com.example.claremountconnection;

public class Opportunity {
    private int id;
    private String post;
    private String skill;
    private String contact;

    public Opportunity() {}

    public Opportunity(String post, String skill, String contact) {
        this.id = id;
        this.post = post;
        this.skill = skill;
        this. contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
