package com.example.p34barboza;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.ArrayList;

@Database(version = 1, entities = { Article.class})
abstract class ArticleDataBase extends RoomDatabase {
    abstract public ArticleDao getArticleDao();
}

