package com.lgd.pojo;

public class Vote {
    private String id;
    private String name;
    private int votenum;

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

    public int getVotenum() {
        return votenum;
    }

    public void setVotenum(int votenum) {
        this.votenum = votenum;
    }

    public Vote(String id, String name, int votenum) {
        this.id = id;
        this.name = name;
        this.votenum = votenum;
    }

    public Vote() {
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", votenum=" + votenum +
                '}';
    }
}
