package com.example.myeonghusong.instagram.database;

/**
 * Created by myeonghusong on 2018. 11. 5..
 */
import java.util.Date;

public class Reply {
    private long id;

    private long feedId;

    private User user;

    private String text;

    private Date createAt;
    private int likeCount;
}
