package ilourenco.com.br.formulariofacil.util;

import android.content.Context;
import android.os.Vibrator;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;

/**
 * Created by webx on 12/02/15.
 */
public class Util {

    public static void vibrate(int timeVibrate) {
        ((Vibrator) FormularioFacilApp.getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(timeVibrate);
    }
}
