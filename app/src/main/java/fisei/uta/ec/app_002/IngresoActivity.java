package fisei.uta.ec.app_002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IngresoActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextClave  = findViewById(R.id.editTextClave);

        registerForContextMenu(editTextClave);
    }

    public void  onClickIngresar(View view)
    {
        String usuario = editTextUsuario.getText().toString();
        String clave = editTextClave.getText().toString();


        if (usuario.equals("admin") && clave.equals("admin"))
        {
            // mostrar un activity
            Intent intent = new Intent(IngresoActivity.this, MainActivity.class);
            //Intent intent = new Intent(this, MainActivity.class);
            // mostrar el activity
            //this.startActivity();

            // pasar parametros
            intent.putExtra("variable_usuario", usuario);
            intent.putExtra("variable_clave", clave);
            //........putExtra

            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Usuario/Clave incorrectos", Toast.LENGTH_SHORT).show();

            //Toast.makeText(getApplicationContext(), "Usuario/Clave incorrectos", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // obtener el id del item donde el usuario presiono
        int id = item.getItemId();

        if (id == R.id.menu_archivo)
        {
            Toast.makeText(this,
                    "Presiono en:Archivo",
                    Toast.LENGTH_LONG).show();
        }

        if (id == R.id.menu_acercade)
        {
            Toast.makeText(this,
                    "Presiono en:Acerca de...",
                    Toast.LENGTH_LONG).show();
        }

        if (id == R.id.menu_copiar)
        {
            Toast.makeText(this,
                    "Presiono en:Copiar",
                    Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contextual, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_configuracion:
                Toast.makeText(this, "Presiono en: configuracion",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_imprimir:
                Toast.makeText(this, "Presiono en: imprimir",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_salir:
                finish();
                break;
        }

        return super.onContextItemSelected(item);
    }
}