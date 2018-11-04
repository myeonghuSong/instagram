package com.example.myeonghusong.instagram.database;

/**
 * Created by myeonghusong on 2018. 11. 5..
 */

import java.util.Date;
import java.util.List;

public class Feed {

    private long id;

    private User user;
    private String text;
    private String imageUrl;
    private int likeCount;
    private int replyCount;
    private List<Reply> subReplies;
    private Date createdAt;

}
