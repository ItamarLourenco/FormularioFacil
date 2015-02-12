package ilourenco.com.br.formulariofacil.fields;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.util.DialogsName;
import ilourenco.com.br.formulariofacil.util.Util;

/**
 * Created by webx on 28/01/15.
 */
public class EditTextField extends Fields implements View.OnTouchListener, View.OnLongClickListener{

    public final static int EDIT_TYPE_NAME = 0;
    public final static int EDIT_TYPE_TYPE = 1;
    public final static int EDIT_TYPE_REMOVE = 2;

    private EditText mEditText;
    private String mName;
    private Activity mActivity;

    public EditTextField(String name, Activity activity) {
        this.mActivity = activity;
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

        mEditText = (EditText) baseForEditText.findViewById(R.id.textField);
        baseForEditText.findViewById(R.id.fieldContainer).setOnTouchListener(this);
        mEditText.setOnLongClickListener(this);

        mEditText.setHint(mName);

        return baseForEditText;
    }

    @Override
    public boolean onLongClick(View v) {
        String[] editInputs = FormularioFacilApp.getContext().getResources().getStringArray(R.array.edit_inputs);
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(R.string.dialog_edit_field).setItems(editInputs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case EDIT_TYPE_NAME:
                        new DialogsName(mActivity, R.string.edd_name) {
                            @Override
                            public void onClick(String name) {
                                mEditText.setHint(name);
                            }
                        };
                        break;

                    case EDIT_TYPE_TYPE:

                        break;
                }
            }
        });
        builder.create();
        builder.show();





        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.fieldContainer:{
                Util.vibrate(15);
                break;
            }
        }
        return false;
    }
}