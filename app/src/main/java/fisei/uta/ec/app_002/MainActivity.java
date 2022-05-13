package fisei.uta.ec.app_002;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fisei.uta.ec.logica.Matematicas;

public class MainActivity extends AppCompatActivity {

    private EditText et_primerValor;
    private EditText et_segundoValor;
    private EditText et_resultado;
    private Button btn_potencia;
    private Button btn_salir;

    private TextView textViewMensaje;

    // Nueva forma de obtener los datos regresados al cerrar
    // un actividad
    ActivityResultLauncher<Intent> activityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // procesar los datos
                    if (result.getResultCode() == Activity.RESULT_OK)
                    {
                        // obtener los datos regresados
                        Intent data =  result.getData();
//                        Toast.makeText(getApplicationContext(),
//                                "Dato regresado" + data.getDataString(),
//                                Toast.LENGTH_LONG).show();
                        textViewMensaje.setText(data.getDataString());
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_primerValor = (EditText) findViewById(R.id.editTextPrimerValor);
        et_segundoValor = findViewById(R.id.editTextSegundoValor);
        et_resultado = findViewById(R.id.editTextResultado);

        textViewMensaje = findViewById(R.id.textViewMensaje);

        // manejador para el evento click del boton
        //btn_potencia = new Button();

       btn_potencia = findViewById(R.id.buttonPotencia);
       btn_salir = findViewById(R.id.buttonSalir);

       btn_potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String b = et_primerValor.getText().toString();
                String e = et_segundoValor.getText().toString();

                int base = Integer.parseInt(b);
                int exponente = Integer.parseInt(e);

                Matematicas matematicas = new Matematicas();

                et_resultado.setText(String.valueOf(matematicas.potencia(base, exponente)));
            }
        });

       btn_salir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

       // obtener los parametros
        Bundle bundle = this.getIntent().getExtras();

       // et_resultado.setText(bundle.getString("variable_usuario"));
       // et_resultado.setText(bundle.getString("variable_clave"));
      //  et_segundoValor.setText(bundle.getString("variable_clave"));
        this.getSupportActionBar().setTitle("Esta conectado con el usuario:" +
                bundle.getString("variable_usuario"));
    }

/*
    public void onClicPotencia(View view) {
        String b = et_primerValor.getText().toString();
        String e = et_segundoValor.getText().toString();

        int base = Integer.parseInt(b);
        int exponente = Integer.parseInt(e);

        /*
        long resultado = 1;

        for (int i=1; i <= exponente; i++)
        {
            resultado *= base;
        }


        Matematicas matematicas = new Matematicas();

        et_resultado.setText(String.valueOf(matematicas.potencia(base, exponente)));

        //et_resultado.setText(String.valueOf(Matematicas.sumar(base, exponente)));
    }
    */

    public void onClicSumar(View view)
    {

    }

    public void onClicMostrarActivity(View view)
    {
        Intent intent = new Intent(this, TercerActivity.class);

        // con el metodod (putExtra) pasar los parametros
        //this.startActivity(intent);

        //startActivityForResult(intent, );
        activityResult.launch(intent);
    }

    public void onClicLlamar(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:+5930992414"));
        //Uri uri = new Uri("");
        startActivity(intent);
    }

    public void onClicMostrarNavegador(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}