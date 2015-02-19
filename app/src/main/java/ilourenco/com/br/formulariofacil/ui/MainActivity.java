package ilourenco.com.br.formulariofacil.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ilourenco.com.br.formulariofacil.R;
import ilourenco.com.br.formulariofacil.provider.FormularioFaciSqllManege;

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

        getContentResolver().insert(FormularioFaciSqllManege.Form.CONTENT_URI, FormularioFaciSqllManege.Form.add("nome_form2"));
    }

}
