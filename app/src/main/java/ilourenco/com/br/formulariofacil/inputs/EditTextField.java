package ilourenco.com.br.formulariofacil.inputs;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;

/**
 * Created by webx on 28/01/15.
 */
public class EditTextField extends Inputs {
    private String name;
    private TextView mTextView;
    private LinearLayout mCanvas;

    public EditTextField(String name) {
        this.name = name;
    }

    public EditTextField(String name, LinearLayout canvas){
        this.mCanvas = canvas;
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCanvas(LinearLayout canvas){
        mCanvas = canvas;
    }

    public LinearLayout getCanvas(){
        return mCanvas;
    }

    public View createView() {
        EditText editText = new EditText(FormularioFacilApp.getContext());
        editText.setHint(name);
        editText.setTextAppearance(FormularioFacilApp.getContext(), R.style.AppTheme);
        return editText;
    }

    public void drawView(){
        mCanvas.addView(createView());
    }

}
