package com.example.myeonghusong.instagram.database;

import java.util.List;

/**
 * Created by myeonghusong on 2018. 11. 5..
 */

public class User {

    private long id;
    private String ID;
    private String pwd;
    private String name;
    private String avatarUrl;
    private List<Integer> followers;
    private List<Integer> followings;
    private List<Feed> feeds;
    private List<Feed> liked_Feeds;
    private List<Feed> researchIds;

}
