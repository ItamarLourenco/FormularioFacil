package ilourenco.com.br.formulariofacil.util;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.view.inputmethod.InputMethodManager;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;

/**
 * Created by webx on 12/02/15.
 */
public class Util {

    public static void vibrate(int timeVibrate) {
        ((Vibrator) FormularioFacilApp.getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(timeVibrate);
    }

    public static void showKeyBoard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static void closeKeyBoard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public static String firstLetterUpperCase(String string){
        string = string.toLowerCase();
        return Character.toString(string.charAt(0)).toUpperCase()+string.substring(1);
    }

    public static String formatNameAndtype(String name, String type){
        return String.format("%s - %s", name, type);
    }
}
