package ilourenco.com.br.formulariofacil.fields;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;

/**
 * Created by webx on 28/01/15.
 */
public class EditTextField extends Fields {
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
        EditText editText = (EditText) baseForEditText.findViewById(R.id.textField);

        ((FrameLayout) baseForEditText.findViewById(R.id.fieldContainer)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Vibrator vibrator = (Vibrator) FormularioFacilApp.getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(15);
                return false;
            }
        });


        editText.setHint(mName);
        return baseForEditText;
    }
}
