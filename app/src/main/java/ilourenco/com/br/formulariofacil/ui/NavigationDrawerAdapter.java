package ilourenco.com.br.formulariofacil.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ilourenco.com.br.formulariofacil.R;

/**
 * Created by webx on 25/01/15.
 */
public class NavigationDrawerAdapter extends BaseAdapter {

    private Context context;
    private String[] menus = null;

    public NavigationDrawerAdapter(Context context, String[] menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return menus.length;
    }

    @Override
    public String getItem(int position) {
        return menus[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.navigation_layout_row, null);
        }
        ((TextView) convertView.findViewById(R.id.title)).setText( getItem(position) );

        return convertView;
    }
}
