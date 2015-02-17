package ilourenco.com.br.formulariofacil.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.provider.FormularioFacilContract;
import ilourenco.com.br.formulariofacil.provider.FormularioFacilProvider;
import ilourenco.com.br.formulariofacil.util.Logger;


public class MainActivity extends BaseActivity{

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_layout);
        drawableMenu();
    }

}
