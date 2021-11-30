package es.udc.juanporta.psi.clean.app.domain.artist.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import es.udc.juanporta.psi.clean.app.data.artist.ArtistDatasourceImpOnline;
import es.udc.juanporta.psi.clean.app.data.artist.ArtistDatasourceImpOffline;
import es.udc.juanporta.psi.clean.app.domain.artist.Artist;
import es.udc.juanporta.psi.clean.app.domain.artist.datasource.ArtistDatasource;

public class ArtistServiceImp implements ArtistService {

    private ArtistDatasource mDatasourceOnline = new ArtistDatasourceImpOnline();
    private ArtistDatasource mDatasourceOffline = new ArtistDatasourceImpOffline();

    @Override
    public List<Artist> searchArtists(String textToSearch, Context context) {
        if (isInternetAvailable(context)){
            return mDatasourceOnline.searchArtists(textToSearch);
        }else return mDatasourceOffline.searchArtists(textToSearch);

    }
    public boolean isInternetAvailable (Context context) {
        ConnectivityManager cm = (ConnectivityManager ) context
                .getSystemService( Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
