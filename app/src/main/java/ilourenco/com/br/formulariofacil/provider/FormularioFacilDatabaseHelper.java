package ilourenco.com.br.formulariofacil.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by itamarlourenco on 16/02/15.
 */
public class FormularioFacilDatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "formulariofacil.db";
    public SQLiteDatabase mSqLiteDatabase;

    private Context mContext;

    public FormularioFacilDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mSqLiteDatabase = db;
        db.execSQL(FormularioFacilSql.Form.CREATE);
        db.execSQL(FormularioFacilSql.Fields.CREATE);
        db.execSQL(FormularioFacilSql.FieldSelect.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
