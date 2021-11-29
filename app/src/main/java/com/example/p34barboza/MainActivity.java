package com.example.p34barboza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArticlesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.articles_rv);
        ArrayList<Article> articles = new ArrayList<>();
        mAdapter = new ArticlesAdapter(articles);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        setArticle("Hol    a", "Adios");
        getArticles();

    }
    private void getArticles() {
        class GetArticles extends AsyncTask<Void, Void, ArrayList<Article>> { // clase  interna
            @Override
            protected ArrayList<Article> doInBackground (Void... voids) {
                List<Article> articleList = ArticleDataBaseClient
                        .getInstance(getApplicationContext())
                        .getArticleDatabase()
                        .getArticleDao()
                        .getAllArticles(); // Sustituir por la función necesaria
                return (ArrayList<Article>) articleList;
            }
            @Override
            protected void onPostExecute (ArrayList<Article> articles) {
                super.onPostExecute(articles);
                mAdapter.setItems(articles); // Actualizar la UI
            }
        }
        GetArticles gf = new GetArticles(); // Crear una instancia y ejecutar
        gf.execute();
    }
    private void setArticle(String title, String subtitle) {
        Article article= new Article();
        article.setTitle(title);
        article.setSubtitle(subtitle);
        class SetArticle extends AsyncTask<Void, Void, Void> { // clase  interna

            @Override
            protected Void doInBackground (Void... voids) {

                ArticleDataBaseClient
                        .getInstance(getApplicationContext())
                        .getArticleDatabase()
                        .getArticleDao()
                        .insert(article); // Sustituir por la función necesaria
                return null;
            }
            @Override
            protected void onPostExecute (Void aVoid) {
                super.onPostExecute(aVoid);
                mAdapter.insertItem(article);
            }
        }
        SetArticle gf = new SetArticle(); // Crear una instancia y ejecutar
        gf.execute();
    }


    private void deleteArticle(int id) {
        Article article = new Article();
        article.setId(id);

        class GetArticles extends AsyncTask<Void, Void, Void> { // clase  interna
            @Override
            protected Void doInBackground (Void... voids) {

                ArticleDataBaseClient
                        .getInstance(getApplicationContext())
                        .getArticleDatabase()
                        .getArticleDao()
                        .delete(article); // Sustituir por la función necesaria
                return null;
            }
            @Override
            protected void onPostExecute (Void aVoid) {
                super.onPostExecute(aVoid);
                mAdapter.deleteItem(article); // Actualizar la UI
            }
        }
        GetArticles gf = new GetArticles(); // Crear una instancia y ejecutar
        gf.execute();
    }

}