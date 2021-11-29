package com.example.p34barboza;

import android.content.Context;

import androidx.room.Room;

public class ArticleDataBaseClient {
    private Context mCtx;
    private static ArticleDataBaseClient mInstance;
    private ArticleDataBase articleDatabase ; //our app database object
    private ArticleDataBaseClient (Context mCtx) {
        this.mCtx = mCtx;
        //creating the app database with Room database builder
        articleDatabase = Room.databaseBuilder(mCtx, ArticleDataBase.class, "Articles.db").build();
// see also option .allowMainThreadQueries() (NOT recommended)
    }
    public static synchronized ArticleDataBaseClient getInstance (Context mCtx) {
        if (mInstance == null)
            mInstance = new ArticleDataBaseClient(mCtx);
        return mInstance;
    }
    public ArticleDataBase getArticleDatabase () {
        return articleDatabase ;
    }

}
