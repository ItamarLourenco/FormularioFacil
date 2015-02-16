package ilourenco.com.br.formulariofacil.provider;

/**
 * Created by itamarlourenco on 16/02/15.
 */
public class FormularioFacilSql extends FormularioFacilContract {
    public static class Form extends Forms{
        public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                            _ID + " INTEGER PRIMARY KEY, " +
                            fields_id + " INTEGER NOT NULL, " +
                            name + " TEXT, " +
                            created_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            update_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                        ");";

        public static final String DELETE = "DELETE FROM " + TABLE_NAME + ";";
    }

    public static class Fields extends FormularioFacilContract.Fields{
        public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                            _ID + " INTEGER PRIMARY KEY, " +
                            name + " TEXT, " +
                            type + " INTEGER NOT NULL, " +
                            is_required + " INTEGER NOT NULL, " +
                            created_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            update_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                        ");";

        public static final String DELETE = "DELETE FROM " + TABLE_NAME + ";";
    }

    public static class FieldSelect extends FieldsSelect{
        public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                            _ID + " INTEGER PRIMARY KEY, " +
                            field_id + " INTEGER NOT NULL, " +
                            option + " TEXT, " +
                            created_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            update_at + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                        ");";

        public static final String DELETE = "DELETE FROM " + TABLE_NAME + ";";
    }
}
