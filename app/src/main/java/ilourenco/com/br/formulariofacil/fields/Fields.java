package ilourenco.com.br.formulariofacil.fields;

import android.view.View;
import android.widget.LinearLayout;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;

/**
 * Created by webx on 27/01/15.
 */
public abstract class Fields {
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_NUMERIC = 1;
    public static final int TYPE_CELPHONE = 2;
    public static final int TYPE_CEP = 3;
    public static final int TYPE_CPF = 4;
    public static final int TYPE_PASSWORD = 5;


    public final static int EDIT_TYPE_NAME = 0;
    public final static int EDIT_TYPE_TYPE = 1;
    public final static int EDIT_TYPE_REMOVE = 2;


    public final static String MASK_CELPHONE = "(##) #####-####";
    public final static String MASK_CEP = "#####-###";
    public final static String MASK_CPF = "###.###.###-##";


    public abstract View getView();
}
