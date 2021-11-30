package es.udc.juanporta.psi.clean.app.data.artist;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import es.udc.juanporta.psi.clean.app.domain.artist.Artist;
import es.udc.juanporta.psi.clean.app.domain.artist.datasource.ArtistDatasource;

public class ArtistDatasourceImpOffline implements ArtistDatasource {
    @Override
    public List<Artist> searchArtists(String textToSearch) {
        class GetArtists extends AsyncTask<Void, Void, ArrayList<Artist>> { // clase  interna
            @Override
            protected ArrayList<Artist> doInBackground (Void... voids) {
                List<Artist> articleList = ArtistDatabaseClient
                        .getInstance(getApplicationContext())
                        .getArticleDatabase()
                        .getArticleDao()
                        .getAllArticles(); // Sustituir por la función necesaria
                return (ArrayList<Artist>) articleList;
            }
            @Override
            protected void onPostExecute (ArrayList<Artist> articles) {
                super.onPostExecute(artists);
            }
        }
        GetArtists gf = new GetArtists(); // Crear una instancia y ejecutar
        gf.execute();
    }
    }
}
