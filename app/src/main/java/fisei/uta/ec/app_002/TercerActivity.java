package fisei.uta.ec.app_002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TercerActivity extends AppCompatActivity {

    private ListView listViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        //listViewDatos = (ListView) findViewById(R.id.listViewDatos);
        listViewDatos = findViewById(R.id.listViewDatos);
        //cargar datos de prueba en el ListView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_expandable_list_item_1,
                        cargarDatosListView());

        // asociar el adapter con el control (vista) que va mostrar los datos
        listViewDatos.setAdapter(adapter);

        // mostrar el item seleccionado al hacer un clic en un item
        listViewDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected = (String) listViewDatos.getAdapter().getItem(i);

                Toast.makeText(getApplicationContext(),
                        "Item seleccionado" + itemSelected,
                        Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }

    private List<String> cargarDatosListView() {
        List<String> list = new ArrayList<String>();

        for (int i=1; i<=200; i++)
        {
            String item = "Numero: " + i;
            list.add(item);
        }

        return list;
    }
}