package ilourenco.com.br.formulariofacil.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ilourenco.com.br.formulariofacil.R;

public class FormsFragment extends BaseFragment implements View.OnClickListener{

    public static Fragment newInstance() {
        FormsFragment fragment = new FormsFragment();
        return fragment;
    }

    public FormsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forms, container, false);

        ((Button) view.findViewById(R.id.create_a_new_form)).setOnClickListener(this);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        BaseActivity.replaceFragment(getActivity().getSupportFragmentManager().beginTransaction(), CreateFormFragment.newInstance());
    }
}
