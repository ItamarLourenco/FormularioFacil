package ilourenco.com.br.formulariofacil.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import ilourenco.com.br.formulariofacil.BuildConfig;

/**
 * Created by itamarlourenco on 17/02/15.
 */
public class FormularioFacilProvider extends ContentProvider {

    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider.app";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int FORM = 1;
    private static final int FIELDS = 2;
    private static final int FIELDS_SELECT = 3;

    private static FormularioFacilDatabaseHelper formularioFacilDatabaseHelper;

    static{
        mUriMatcher.addURI(AUTHORITY, FormularioFacilContract.Forms.TABLE_NAME, FORM);
        mUriMatcher.addURI(AUTHORITY, FormularioFacilContract.Fields.TABLE_NAME, FIELDS);
        mUriMatcher.addURI(AUTHORITY, FormularioFacilContract.FieldsSelect.TABLE_NAME, FIELDS_SELECT);
    }

    @Override
    public boolean onCreate() {
        formularioFacilDatabaseHelper = new FormularioFacilDatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase sqLiteDatabase = formularioFacilDatabaseHelper.getWritableDatabase();
        long id;
        String tableName;

        switch (mUriMatcher.match(uri)){
            case FORM:
                tableName = FormularioFaciSqllManege.Form.TABLE_NAME;
                id = sqLiteDatabase.insert(tableName, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return Uri.parse(tableName + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
