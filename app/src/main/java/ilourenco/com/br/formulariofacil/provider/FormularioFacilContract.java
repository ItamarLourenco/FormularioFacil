package ilourenco.com.br.formulariofacil.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import ilourenco.com.br.formulariofacil.BuildConfig;

/**
 * Created by itamarlourenco on 16/02/15.
 */
public class FormularioFacilContract {

    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider.app";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public interface Columns extends BaseColumns{
        public static final String created_at = "created_at";
        public static final String update_at = "update_at";
    }

    public static class Forms implements Columns {
        public static final String TABLE_NAME = "forms";

        public static final String fields_id = "fields_id";
        public static final String name = "name";
    }

    public static class Fields implements Columns{
        public static final String TABLE_NAME = "fields";

        public static final String name = "name";
        public static final String type = "type";
        public static final String is_required = "is_required";
    }

    public static class FieldsSelect implements Columns{
        public static final String TABLE_NAME = "fields_select";

        public static final String field_id = "field_id";
        public static final String option = "option";
    }

}
