package es.udc.juanporta.psi.clean.app;

import android.app.Application;

import butterknife.ButterKnife;

public class GlobalApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        initButterKnifeDebug();
    }

    private void initButterKnifeDebug() {

        //ButterKnife.setDebug(BuildConfig.DEBUG);
    }
}
