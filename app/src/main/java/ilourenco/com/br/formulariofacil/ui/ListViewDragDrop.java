package ilourenco.com.br.formulariofacil.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.helpers.DynamicListView.Cheeses;
import ilourenco.com.br.formulariofacil.helpers.DynamicListView.DynamicListView;
import ilourenco.com.br.formulariofacil.helpers.DynamicListView.StableArrayAdapter;

public class ListViewDragDrop extends BaseFragment {

    public static ListViewDragDrop newInstance() {
        ListViewDragDrop fragment = new ListViewDragDrop();
        return fragment;
    }

    public static final String[] teste = {"teste1", "Teste2", "teste3"};

    public ListViewDragDrop() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view_drag_drop, container, false);

        ArrayList<String>mCheeseList = new ArrayList<String>();
        for (int i = 0; i < Cheeses.sCheeseStrings.length; ++i) {
            mCheeseList.add(Cheeses.sCheeseStrings[i]);
        }

        StableArrayAdapter adapter = new StableArrayAdapter(FormularioFacilApp.getContext(), R.layout.text_view, mCheeseList);
        DynamicListView listView = (DynamicListView) view.findViewById(R.id.listview);

        listView.setCheeseList(mCheeseList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        return view;
    }

}
