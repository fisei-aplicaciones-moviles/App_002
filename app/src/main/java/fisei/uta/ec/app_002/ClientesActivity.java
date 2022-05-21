package fisei.uta.ec.app_002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

public class ClientesActivity extends AppCompatActivity {

    private EditText editTextCodigo;
    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextSaldo = findViewById(R.id.editTextSaldo);

    }

    public void onClicInsertar(View view)
    {
        ClientsDataBase clientsDataBase = new ClientsDataBase(this, "CLIENTES_DB", null, 1);

        // abrir la BD en modo lectura (SELECT)
        //SQLiteDataBase sql = clientsDataBase.getReadableDatabase()

        // abrir la BD en modo escritura (SELECT, DML, DDL)
        SQLiteDatabase sql = clientsDataBase.getWritableDatabase();

        // obtener los datos ingresados en los controles
        String codigo = editTextCodigo.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        String saldo = editTextSaldo.getText().toString();

        // problemas de seguridad: SQL INJECTION
        //sql.execSQL("INSERT INTO Clientes(Codigo, Nombre, Apellido, Saldo) " +
        //        " VALUES('"+codigo+"', '"+nombre+"', "+saldo+")");

        ContentValues values = new ContentValues();
        //values.put("Codigo", codigo);
        values.put("Nombre", nombre);
        values.put("Apellido", apellido);
        values.put("Saldo", saldo);

        // enviar a la base de datos
        sql.insert("Clientes",null, values);

        //cerrar la Base de Datos
        sql.close();

        limpiarControles();

        Toast.makeText(this, "Se inserto el cliente", Toast.LENGTH_SHORT).show();

    }

    private void limpiarControles() {
        //Limpiar los controles
        editTextCodigo.setText("");
        ;
        editTextNombre.setText("");
        editTextApellido.setText("");
        editTextSaldo.setText("");
    }

    public void onClicBorrar(View view)
    {
        // crear a base de datos y regresar el puntero al archivo de base datos
        ClientsDataBase clientsDataBase = new ClientsDataBase(this, "CLIENTES_DB", null, 1);

        // abrir la BD en modo lectura (SELECT)
        //SQLiteDataBase sql = clientsDataBase.getReadableDatabase()

        // abrir la BD en modo escritura (SELECT, DML, DDL)
        SQLiteDatabase sql = clientsDataBase.getWritableDatabase();

        //

    }

    public void onClicModificar(View view)
    {
        // crear a base de datos y regresar el puntero al archivo de base datos
        ClientsDataBase clientsDataBase = new ClientsDataBase(this, "CLIENTES_DB", null, 1);

        // abrir la BD en modo lectura (SELECT)
        //SQLiteDataBase sql = clientsDataBase.getReadableDatabase()

        // abrir la BD en modo escritura (SELECT, DML, DDL)
        SQLiteDatabase sql = clientsDataBase.getWritableDatabase();
    }

    public void onClicBuscar(View view)
    {
        // crear a base de datos y regresar el puntero al archivo de base datos
        ClientsDataBase clientsDataBase = new ClientsDataBase(this, "CLIENTES_DB", null, 1);

        // abrir la BD en modo lectura (SELECT)
        SQLiteDatabase sql = clientsDataBase.getReadableDatabase();

        // abrir la BD en modo escritura (SELECT, DML, DDL)
       // SQLiteDataBase sql = clientsDataBase.getWritableDatabase();

        // obtener el codigo del cliente para realizar la busqueda
        String codigo = editTextCodigo.getText().toString();

        //String SELECT = "SELECT * FROM Clientes WHERE Codigo=" + codigo;
        String SELECT = "SELECT Nombre, Apellido, Saldo " +
                        "FROM Clientes WHERE Codigo=" + codigo;

        // SELECT Codigo (0), Nombre (1), Apellido (2), Saldo (3)

        Cursor cursor = sql.rawQuery(SELECT, null);

        //while
        if (cursor.moveToFirst())
        {
            editTextNombre.setText(cursor.getString(0));
            editTextApellido.setText(cursor.getString(1));
            editTextSaldo.setText(cursor.getString(2));
        }
        else
        {
            Toast.makeText(this, "No se encontro el cliente", Toast.LENGTH_SHORT).show();
            limpiarControles();
        }

        // cerrar la base de datos
        sql.close();
    }

    public void onClicMostrarClientes(View view)
    {
        // crear a base de datos y regresar el puntero al archivo de base datos
        ClientsDataBase clientsDataBase = new ClientsDataBase(this, "CLIENTES_DB", null, 1);

        // abrir la BD en modo lectura (SELECT)
        SQLiteDatabase sql = clientsDataBase.getReadableDatabase();

        // abrir la BD en modo escritura (SELECT, DML, DDL)
        //SQLiteDataBase sql = clientsDataBase.getWritableDatabase();
    }
}