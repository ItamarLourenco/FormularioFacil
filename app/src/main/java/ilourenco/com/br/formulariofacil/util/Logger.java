package ilourenco.com.br.formulariofacil.util;
import android.util.Log;
import android.widget.Toast;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;

public class Logger {

    private static final String TAG = "FormularioFacil";

    public static void d(Object message) {
        Log.d(TAG, String.valueOf(message));
    }

    public static void e(Object message) {
        Log.e(TAG, String.valueOf(message));
    }

    public static void i(Object message) {
        Log.i(TAG, String.valueOf(message));
    }

    public static void w(Object message) {
        Log.w(TAG, String.valueOf(message));
    }

    public static void v(Object message) {
        Log.v(TAG, String.valueOf(message));
    }

    public static void t(Object message){
        Toast.makeText(FormularioFacilApp.getContext(), String.valueOf(message), Toast.LENGTH_LONG).show();
        d(String.valueOf(message));
    }
}