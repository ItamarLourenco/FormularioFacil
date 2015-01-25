package ilourenco.com.br.formulariofacil.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ilourenco.com.br.formulariofacil.R;

public class CreateFormFragment extends Fragment {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_form, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
