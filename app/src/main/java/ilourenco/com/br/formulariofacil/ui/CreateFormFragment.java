package ilourenco.com.br.formulariofacil.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.model.Form;

public class CreateFormFragment extends BaseFragment implements View.OnClickListener{

    private Form mForm;
    private Button mButtonAddNewName;
    private EditText mEditTextOfNewName;
    private Dialog mDialog;
    private LinearLayout mCanvas;


    public static CreateFormFragment newInstance() {
        CreateFormFragment fragment = new CreateFormFragment();
        return fragment;
    }

    public CreateFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void showDialogNameForm() {
        mDialog = new Dialog(getActivity());
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mDialog.setContentView(R.layout.dialog_name_of_form);
        Window window = mDialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
        lp.dimAmount = 0.40f;
        mDialog.getWindow().setAttributes(lp);
        mDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mDialog.setCancelable(false);
        mDialog.show();

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

        mButtonAddNewName = (Button) mDialog.findViewById(R.id.add_new_name);
        mEditTextOfNewName = (EditText) mDialog.findViewById(R.id.edit_text_of_new_form);
        mButtonAddNewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createForm();
            }
        });
    }

    private void createForm() {
        String nameOfNewForm = mEditTextOfNewName.getText().toString();
        if(!TextUtils.isEmpty(nameOfNewForm)){
            mForm = new Form(nameOfNewForm, mCanvas);
            mForm.drawerName();
            mDialog.dismiss();
        }else{
            Crouton.makeText(getActivity(), R.string.error_add_new_name_form, Style.ALERT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_form, container, false);
        showDialogNameForm();

        mCanvas = (LinearLayout) view.findViewById(R.id.canvas);
        ((Button) view.findViewById(R.id.create_a_new_form)).setOnClickListener(this);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_a_new_form:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.dialog_inputs_name).setItems(R.array.type_of_inputs, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create();
                builder.show();
                break;
        }
    }
}
