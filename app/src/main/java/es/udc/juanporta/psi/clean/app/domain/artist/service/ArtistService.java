package es.udc.juanporta.psi.clean.app.domain.artist.service;

import android.content.Context;

import java.util.List;

import es.udc.juanporta.psi.clean.app.domain.artist.Artist;

public interface ArtistService {

    List<Artist> searchArtists(String textToSearch, Context context);
}
