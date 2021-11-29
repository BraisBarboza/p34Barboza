package com.example.p34barboza;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
interface ArticleDao {
    /*@Query("SELECT * FROM articles" )
    public Article[] getArtists();*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Article articles);

    @Query("SELECT * FROM articles" )
    public List<Article> getAllArticles();
    @Delete
    public void delete(Article article);


}
