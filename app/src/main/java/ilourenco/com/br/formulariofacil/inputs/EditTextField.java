package ilourenco.com.br.formulariofacil.inputs;

import android.view.View;
import android.widget.EditText;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;

/**
 * Created by webx on 28/01/15.
 */
public class EditTextField extends Inputs {
    private String mName;

    public EditTextField(String name) {
        this.mName = name;
    }

    public void setName(String name){
        this.mName = name;
    }
    public String getName(){
        return mName;
    }

    @Override
    public View getView() {
        View baseForEditText = View.inflate(FormularioFacilApp.getContext(), R.layout.field_edit_text, null);
        EditText editText = (EditText) baseForEditText.findViewById(R.id.noteText);
        editText.setHint(mName);

        return baseForEditText;
    }
}
