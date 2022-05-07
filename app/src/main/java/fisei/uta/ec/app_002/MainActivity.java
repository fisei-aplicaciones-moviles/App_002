package fisei.uta.ec.app_002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fisei.uta.ec.logica.Matematicas;

public class MainActivity extends AppCompatActivity {

    private EditText et_primerValor;
    private EditText et_segundoValor;
    private EditText et_resultado;
    private Button btn_potencia;
    private Button btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_primerValor = (EditText) findViewById(R.id.editTextPrimerValor);
        et_segundoValor = findViewById(R.id.editTextSegundoValor);
        et_resultado = findViewById(R.id.editTextResultado);

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
        Bundle bundle = getIntent().getExtras();

       // et_resultado.setText(bundle.getString("variable_usuario"));
        et_resultado.setText(bundle.getString("variable_clave"));
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
}