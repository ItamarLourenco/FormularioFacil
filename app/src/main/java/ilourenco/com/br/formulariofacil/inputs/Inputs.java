package ilourenco.com.br.formulariofacil.inputs;

import android.widget.LinearLayout;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;

/**
 * Created by webx on 27/01/15.
 */
public class Inputs {
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_NUMERIC = 1;
    public LinearLayout mLinearLayout = null;

    public void baseInput(){
        LinearLayout mLinearLayout = new LinearLayout(FormularioFacilApp.getContext());
        
    }
}
