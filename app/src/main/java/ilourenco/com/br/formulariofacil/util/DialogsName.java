package ilourenco.com.br.formulariofacil.util;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ilourenco.com.br.formulariofacil.R;

/**
 * Created by webx on 28/01/15.
 */
public class DialogsName {
    public Activity mAct;
    public Dialog mDialog;
    public DialogsName(Activity act){
        mAct = act;
        dialogForNameText(act);
    }

    public void dialogForNameText(Activity activity){
        mDialog = new Dialog(activity);
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

        ((TextView) mDialog.findViewById(R.id.title)).setText(R.string.name_field_of_text);
        ((TextView) mDialog.findViewById(R.id.edit_text)).setHint(R.string.type_a_name_of_input_text);
        Button addNewName = ((Button) mDialog.findViewById(R.id.add_button));
        addNewName.setText(R.string.add_new_name);

        final EditText editText = (EditText) mDialog.findViewById(R.id.edit_text);
        addNewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName(editText.getText().toString());
                mDialog.dismiss();
            }
        });

        mDialog.show();
    }
    public void getName(String name){

    };
}
