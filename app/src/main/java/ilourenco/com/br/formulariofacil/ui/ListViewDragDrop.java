package ilourenco.com.br.formulariofacil.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

import ilourenco.com.br.formulariofacil.R;

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

        DragLinearLayout dragLinearLayout = (DragLinearLayout) view.findViewById(R.id.container);
        for(int i = 0; i < dragLinearLayout.getChildCount(); i++){
            View child = dragLinearLayout.getChildAt(i);
            // the child will act as its own drag handle
            dragLinearLayout.setViewDraggable(child, child);
        }


        return view;
    }

}
