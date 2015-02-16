package ilourenco.com.br.formulariofacil.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.fields.Fields;

/**
 * Created by webx on 28/01/15.
 */
public class DialogsName {
    private Activity mActivity;
    private Dialog mDialog;
    private int mTypeField;
    private String mNameText;

    public DialogsName(Activity act){
        this(act, Fields.TYPE_TEXT, null);
    }

    public DialogsName(Activity act, String nameText){
        this(act, Fields.TYPE_TEXT, nameText);
    }

    public DialogsName(Activity act, int typeField){
        this(act, typeField, null);
    }

    public DialogsName(Activity act, int typeField, String nameText){
        mActivity = act;
        mTypeField = typeField;
        mNameText = nameText;

        setAndDialog();
    }

    private void setAndDialog() {
        String name = "";
        String hint = "";
        String textButton = "";

        switch (mTypeField){
            case Fields.TYPE_TEXT:
                name = FormularioFacilApp.getContext().getString(R.string.name_field_of_text);
                hint = FormularioFacilApp.getContext().getString(R.string.type_a_name_of_input_text);
                textButton = FormularioFacilApp.getContext().getString(R.string.add_new_name);
            break;

            case Fields.TYPE_NUMERIC:
                name = FormularioFacilApp.getContext().getString(R.string.name_field_of_numeric);
                hint = FormularioFacilApp.getContext().getString(R.string.type_a_name_of_input_numeric);
                textButton = FormularioFacilApp.getContext().getString(R.string.add_new_name);
            break;

            case Fields.TYPE_CELPHONE:
                name = FormularioFacilApp.getContext().getString(R.string.name_field_of_celphone);
                hint = FormularioFacilApp.getContext().getString(R.string.type_a_name_of_input_celphone);
                textButton = FormularioFacilApp.getContext().getString(R.string.add_new_name);
                break;

            case Fields.TYPE_CEP:
                name = FormularioFacilApp.getContext().getString(R.string.name_field_of_cep);
                hint = FormularioFacilApp.getContext().getString(R.string.type_a_name_of_input_cep);
                textButton = FormularioFacilApp.getContext().getString(R.string.add_new_name);
                break;
        }

        dialogForNameText(name, hint, textButton);
    }

    private void dialogForNameText(String name, String hint, String textButton){
        mDialog = new Dialog(mActivity);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mDialog.setContentView(R.layout.dialog_default_text_view);
        Window window = mDialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
        lp.dimAmount = 0.40f;
        mDialog.getWindow().setAttributes(lp);
        mDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mDialog.setCancelable(false);

        ((TextView) mDialog.findViewById(R.id.title)).setText(name);

        EditText editTextForName = (EditText) mDialog.findViewById(R.id.edit_text);
        editTextForName.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        editTextForName.setHint(hint);
        if(!TextUtils.isEmpty(mNameText)){
            editTextForName.setText(mNameText);
        }
        editTextForName.setSelection(editTextForName.getText().length());

        Button addNewName = ((Button) mDialog.findViewById(R.id.add_button));
        addNewName.setText(textButton);

        final EditText editText = (EditText) mDialog.findViewById(R.id.edit_text);
        addNewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogsName.this.onClick(editText.getText().toString());
                mDialog.dismiss();
            }
        });

        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dialog.dismiss();
                    return true;
                }
                return false;
            }
        });

        mDialog.show();
    }

    public void onClick(String name){};
}