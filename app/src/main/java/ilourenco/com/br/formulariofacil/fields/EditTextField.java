package ilourenco.com.br.formulariofacil.fields;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.util.DialogsName;
import ilourenco.com.br.formulariofacil.util.Util;

/**
 * Created by webx on 28/01/15.
 */
public class EditTextField extends Fields implements View.OnTouchListener, View.OnLongClickListener{

    private EditText mEditText;
    private String mName;
    private Activity mActivity;
    private int mTypeField;
    private String[] mTypeOfFields;
    private LinearLayout mBaseForTextView;

    public EditTextField(String name, Activity activity, int typeFiel) {
        this.mActivity = activity;
        this.mName = name;
        this.mTypeField = typeFiel;
        this.mTypeOfFields = FormularioFacilApp.getContext().getResources().getStringArray(R.array.types_of_inputs);
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

        mBaseForTextView = (LinearLayout) baseForEditText.findViewById(R.id.baseForEditText);
        mEditText = (EditText) baseForEditText.findViewById(R.id.textField);
        baseForEditText.findViewById(R.id.fieldContainer).setOnTouchListener(this);
        mEditText.setOnLongClickListener(this);

        setTypeOfEditText();
        updateName();

        return baseForEditText;
    }

    private void setTypeOfEditText() {
        switch (mTypeField){
            case Fields.TYPE_TEXT:
                mEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                break;

            case Fields.TYPE_NUMERIC:
                mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        String[] editInputs = FormularioFacilApp.getContext().getResources().getStringArray(R.array.edit_inputs);
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(R.string.dialog_edit_field).setItems(editInputs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case EDIT_TYPE_NAME:
                        new DialogsName(mActivity, mTypeField, mName) {
                            @Override
                            public void onClick(String name) {
                                mName = name;
                                updateName();
                            }
                        };
                        break;

                    case EDIT_TYPE_TYPE:
                        openDialogWithTypeOfInputs();
                        break;

                    case EDIT_TYPE_REMOVE:
                        mBaseForTextView.removeAllViews();
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

    private void openDialogWithTypeOfInputs() {
        String[] mTypeOfInputs = FormularioFacilApp.getContext().getResources().getStringArray(R.array.types_of_inputs);
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(R.string.dialog_inputs_name).setItems(mTypeOfInputs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int type) {
                tradeTypeOfField(type);
            }
        });
        builder.create();
        builder.show();
    }

    private void tradeTypeOfField(int type) {
        switch (type){
            case Fields.TYPE_TEXT:
                mTypeField = Fields.TYPE_TEXT;
                break;

            case Fields.TYPE_NUMERIC:
                mTypeField = Fields.TYPE_NUMERIC;
                break;
        }
        updateName();
        setTypeOfEditText();
    }

    public void updateName(){
        mEditText.setHint(Util.formatNameAndtype(mName, mTypeOfFields[mTypeField]));
    }
}