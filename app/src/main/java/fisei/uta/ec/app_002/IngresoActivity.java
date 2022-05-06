package fisei.uta.ec.app_002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
}