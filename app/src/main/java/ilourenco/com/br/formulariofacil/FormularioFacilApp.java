package ilourenco.com.br.formulariofacil;

import android.app.Application;
import android.content.Context;

/**
 * Created by webx on 25/01/15.
 */
public class FormularioFacilApp extends Application{
    private static FormularioFacilApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getContext(){
        return sInstance;
    }
}
