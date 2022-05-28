package fisei.uta.ec.AccesoDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import fisei.uta.ec.Entidades.Cliente;

import fisei.uta.ec.app_002.ClientsDataBase;

public class ClienteDAL {
    private ClientsDataBase dataBase; //crear la BD.
    private SQLiteDatabase sql; //comandos SQL
    private Context context; // para usar en el constructor

    public ClienteDAL(Context context) {
        this.context = context;
    }

    private void open(int mode) {
        dataBase = new ClientsDataBase(context, "CLIENTES_DB", null, 1 );

        if (mode == 0)
        {
            sql = dataBase.getReadableDatabase();
        }

        if (mode == 1)
        {
            sql = dataBase.getWritableDatabase();
        }
    }

    public void close() {
        sql.close();
    }

    public long insert(Cliente cliente) {
        long count = 0;

        try {
            //crear la Base Datos y abrir en modo escritura
            open(1);

            ContentValues values = new ContentValues();
            //values.put("Codigo", codigo);
            values.put("Nombre", cliente.getNombre());
            values.put("Apellido", cliente.getApellido());
            values.put("Saldo", cliente.getSaldo());

            // enviar a la base de datos
            //long cantidad = sql.insert("Clientes",null, values);
            count = sql.insert("Clientes",null, values);
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            sql.close();
        }

        return count;
    }

    public Cliente selectByCodigo (int codigo) {
        Cliente cliente = null;

        try {
            open(0);

            String SELECT = "SELECT Nombre, Apellido, Saldo " +
                            "FROM Clientes WHERE Codigo=" + codigo;

            // SELECT Codigo (0), Nombre (1), Apellido (2), Saldo (3)

            Cursor cursor = sql.rawQuery(SELECT, null);

            //while
            if (cursor.moveToFirst())
            {
                cliente = new Cliente();

                cliente.setNombre(cursor.getString(0));
                cliente.setApellido(cursor.getString(1));
                cliente.setSaldo(Double.parseDouble(cursor.getString(2)));
            }
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            sql.close();
        }

        return  cliente;
    }

    // ArrayList<Cliente>
    // List<Cliente>
    //public ArrayList<Cliente>
    public ArrayList<String> select() {
        ArrayList<String > list = null;

        try {
            open(0);

            String SELECT = "SELECT Codigo, Nombre, Apellido, Saldo " +
                            "FROM Clientes";
            Cursor cursor = sql.rawQuery(SELECT, null);

            if (cursor.moveToFirst()) {
                list = new ArrayList<String>();

                //regresar los n registros
                do {
                    list.add(cursor.getString(0) + "    " +
                            cursor.getString(1) + "    " +
                            cursor.getString(2) + "    " +
                            cursor.getString(3)
                            );
                }while (cursor.moveToNext());
            }
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            sql.close();
        }

        return  list;
    }

    public int update (Cliente cliente) {
        int count = 0;

        try {
            //crear la Base Datos y abrir en modo escritura
            open(1);

            ContentValues values = new ContentValues();
            values.put("Nombre", cliente.getNombre());
            values.put("Apellido", cliente.getApellido());
            values.put("Saldo", cliente.getSaldo());

            //values.put("Codigo", cliente.getCodigo());

            // enviar a la base de datos
            count = sql.update("Clientes", values,
                    "Codigo=" + cliente.getCodigo(), null);
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            sql.close();
        }

        return count;
    }

    public int delete (int codigo) {
        int count = 0;

        try {
            open(1);

            // eliminar el registro
            count = sql.delete("Clientes",
                    "Codigo=" + codigo, null );
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            sql.close();
        }

        return count;
    }
}
