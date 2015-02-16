package ilourenco.com.br.formulariofacil.fields;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.util.DialogsName;
import ilourenco.com.br.formulariofacil.util.Logger;
import ilourenco.com.br.formulariofacil.util.Mask;
import ilourenco.com.br.formulariofacil.util.Util;

/**
 * Created by webx on 28/01/15.
 */
public class EditTextField extends Fields implements View.OnTouchListener, View.OnLongClickListener, View.OnClickListener{

    private EditText mEditText;
    private String mName;
    private Activity mActivity;
    private int mTypeField;
    private LinearLayout mBaseForTextView;
    private ImageView mPopUp;
    private String[] mEditInputs;
    private String[] mTypeOfFields;

    public EditTextField(String name, Activity activity, int typeFiel) {
        this.mActivity = activity;
        this.mName = name;
        this.mTypeField = typeFiel;
        this.mTypeOfFields = FormularioFacilApp.getContext().getResources().getStringArray(R.array.types_of_inputs);
        this.mEditInputs = FormularioFacilApp.getContext().getResources().getStringArray(R.array.edit_inputs);
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

        mPopUp = (ImageView) baseForEditText.findViewById(R.id.popup);
        mPopUp.setOnClickListener(this);

        setTypeOfEditText();
        updateName();

        return baseForEditText;
    }

    private void setTypeOfEditText() {
        mEditText.setText(null);
        switch (mTypeField){
            case Fields.TYPE_TEXT:
                mEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                break;

            case Fields.TYPE_NUMERIC:
                mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;

            case Fields.TYPE_CELPHONE:
                mEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                break;

            case Fields.TYPE_CEP:
                mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setItems(mEditInputs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                selectedOptionOfEdit(which);
            }
        });
        builder.create();
        builder.show();
        return false;
    }

    private void selectedOptionOfEdit(int selected) {
        switch (selected) {
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

            case Fields.TYPE_CELPHONE:
                mTypeField = Fields.TYPE_CELPHONE;
                break;

            case Fields.TYPE_CEP:
                mTypeField = Fields.TYPE_CEP;
                break;
        }
        updateName();
        setTypeOfEditText();
    }

    public void updateName(){
        mEditText.setHint(Util.formatNameAndtype(mName, mTypeOfFields[mTypeField]));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.popup:{
                openPupUpMenu();
                break;
            }
        }
    }

    private void openPupUpMenu() {
        int idForMenu = 0;

        PopupMenu popup = new PopupMenu(mActivity, mPopUp);
        popup.getMenuInflater().inflate(R.menu.menu_edit_text, popup.getMenu());

        for(String menu : mEditInputs){
            popup.getMenu().add(0, idForMenu, idForMenu, menu);
            idForMenu++;
        }

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                selectedOptionOfEdit(item.getItemId());
                return true;
            }
        });

        popup.show();
    }
}