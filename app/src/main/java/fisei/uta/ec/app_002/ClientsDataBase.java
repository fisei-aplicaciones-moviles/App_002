package fisei.uta.ec.app_002;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClientsDataBase extends SQLiteOpenHelper {

    private String CREATE_TABLE_CLIENTES = "CREATE TABLE Clientes (Codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Nombre TEXT, Apellido TEXT, Saldo REAL)";

    public ClientsDataBase(@Nullable Context context, @Nullable String name,
                           @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //1) Crear la estructura de la base de datos
        sqLiteDatabase.execSQL(CREATE_TABLE_CLIENTES);

        //2) Agregar datos en las tablas (de forma opcional)
        // INSERT INTO.......
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // 1) Los cambios requeridos en la estructura de la Base Datos

        //if (sqLiteDatabase.)
        sqLiteDatabase.execSQL(CREATE_TABLE_CLIENTES);

    }
}
