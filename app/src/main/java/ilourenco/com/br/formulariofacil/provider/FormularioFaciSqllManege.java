package ilourenco.com.br.formulariofacil.provider;

import android.content.ContentValues;
import android.net.Uri;

/**
 * Created by itamarlourenco on 16/02/15.
 */
public class FormularioFaciSqllManege extends FormularioFacilContract {
    public static class Form extends Forms{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(FormularioFacilProvider.AUTHORITY_URI, TABLE_NAME);

        public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                            _ID + " INTEGER PRIMARY KEY, " +
                            name + " TEXT, " +
                            created_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            update_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                        ");";

        public static final String DELETE = "DELETE FROM " + TABLE_NAME + ";";

        public static ContentValues add(String name){
            ContentValues values = new ContentValues();
            values.put(Forms.name, name);
            return values;
        }
    }

    public static class Fields extends FormularioFacilContract.Fields{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(FormularioFacilProvider.AUTHORITY_URI, TABLE_NAME);

        public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                            _ID + " INTEGER PRIMARY KEY, " +
                            name + " TEXT, " +
                            type + " INTEGER NOT NULL, " +
                            is_required + " INTEGER NOT NULL, " +
                            created_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            update_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                        ");";

        public static final String DELETE = "DELETE FROM " + TABLE_NAME + ";";

        public static ContentValues add(String name, int type, boolean is_required){
            ContentValues values = new ContentValues();
            values.put(Fields.name, name);
            values.put(Fields.type, type);
            values.put(Fields.is_required, is_required);
            return values;
        }
    }

    public static class FieldSelect extends FieldsSelect{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(FormularioFacilProvider.AUTHORITY_URI, TABLE_NAME);

        public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                            _ID + " INTEGER PRIMARY KEY, " +
                            field_id + " INTEGER NOT NULL, " +
                            option + " TEXT, " +
                            created_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            update_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                        ");";

        public static final String DELETE = "DELETE FROM " + TABLE_NAME + ";";

        public static ContentValues add(int field_id, String option){
            ContentValues values = new ContentValues();
            values.put(FieldsSelect.field_id, field_id);
            values.put(FieldsSelect.option, option);
            return values;
        }
    }
}
