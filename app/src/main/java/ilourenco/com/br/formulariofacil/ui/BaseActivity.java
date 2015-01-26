package ilourenco.com.br.formulariofacil.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import ilourenco.com.br.formulariofacil.FormularioFacilApp;
import ilourenco.com.br.formulariofacil.R;

import static ilourenco.com.br.formulariofacil.R.array;
import static ilourenco.com.br.formulariofacil.R.id;


/**
 * Created by webx on 25/01/15.
 */
public class BaseActivity extends ActionBarActivity {

    public static final int NAV_FORMS = 0;
    public static final int NAV_CREATE_FORM = 1;
    public static final int NAV_SETTING = 2;

    public String[] mNavigationDrawerAdapter;
    public DrawerLayout mDrawerLayout;
    public ListView mListView;
    public ActionBarDrawerToggle mActionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpNavigationEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setUpNavigationEnabled(boolean upNavEnabled) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(upNavEnabled);
        actionBar.setDisplayHomeAsUpEnabled(upNavEnabled);
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }


    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public void drawableMenu() {
        mListView = (ListView) findViewById(id.list_navigation);
        mDrawerLayout = (DrawerLayout) findViewById(id.drawer_layout);
        mNavigationDrawerAdapter = getResources().getStringArray(array.navigation_drawer_adapter);

        mListView.setAdapter(new NavigationDrawerAdapter(FormularioFacilApp.getContext(), mNavigationDrawerAdapter));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClickMenu(parent, view, position, id);
            }
        });

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_launcher, R.drawable.ic_launcher){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        //Start Fragments
        displayView(NAV_FORMS);
    }

    private void onItemClickMenu(AdapterView<?> parent, View view, int position, long id) {
        displayView(position);
    }

    public void displayView(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case NAV_FORMS:
                fragment = FormsFragment.newInstance();
                break;

            case NAV_CREATE_FORM:
                fragment = CreateFormFragment.newInstance();
                break;

            case NAV_SETTING:
                fragment = SettingFragment.newInstance();
                break;
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(id.frame_container, fragment);
            fragmentTransaction.commit();

            mListView.setItemChecked(position, true);
            mListView.setSelection(position);

            mDrawerLayout.closeDrawer(mListView);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}


