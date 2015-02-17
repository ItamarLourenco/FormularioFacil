package ilourenco.com.br.formulariofacil.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import ilourenco.com.br.formulariofacil.util.Logger;

/**
 * Created by itamarlourenco on 17/02/15.
 */
public class FormularioFacilProvider extends ContentProvider {

    public static final Uri CONTENT_URI = FormularioFacilContract.AUTHORITY_URI;
    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    @Override
    public boolean onCreate() {
        return true;
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
        Logger.t(sUriMatcher.match(uri));
        return null;
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
