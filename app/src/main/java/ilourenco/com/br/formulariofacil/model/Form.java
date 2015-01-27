package ilourenco.com.br.formulariofacil.model;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;

/**
 * Created by webx on 27/01/15.
 */
public class Form {
    private String name;
    private String created_at;
    private Input[] inputs;
    private LinearLayout mCanvas;

    public Form() {
    }

    public Form(String name) {
        this.name = name;
    }

    public Form(String name, LinearLayout canvas) {
        this.name = name;
        this.mCanvas = canvas;
    }

    public String getName() {
        return name;
    }

    public LinearLayout getCanvas(){
        return mCanvas;
    }

    public void setCanvas(LinearLayout canvas){
        mCanvas = canvas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Input[] getInputs() {
        return inputs;
    }

    public void setInputs(Input[] inputs) {
        this.inputs = inputs;
    }

    public TextView getTextViewOfName(){
        if(mCanvas != null && !TextUtils.isEmpty(getName())) {
            TextView textView = new TextView(FormularioFacilApp.getContext());
            textView.setText(getName());
            textView.setTextAppearance(FormularioFacilApp.getContext(), R.style.FormularioFacil_NameOfForm);

            return textView;
        }
        return null;
    }

    public void drawerName() {
        TextView textViewOfName = getTextViewOfName();
        if(textViewOfName != null){
            getCanvas().addView(textViewOfName);
        }
    }
}
