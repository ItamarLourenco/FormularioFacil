package ilourenco.com.br.formulariofacil.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import ilourenco.com.br.formulariofacil.R;

public class CreateFormFragment extends BaseFragment {

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
        showDialogNameForm();
    }

    private void showDialogNameForm() {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.setContentView(R.layout.dialog_name_of_form);
        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.80f;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_form, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
