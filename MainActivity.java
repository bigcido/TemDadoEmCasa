/*
@author = Alvaro Dias
RA 1110482223004
 */
package br.edu.fateczl.temdadoemcasa;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.temdadoemcasa.R.id;

public class MainActivity extends AppCompatActivity {

    private TextView txtRes;
    private RadioButton Dado4;
    private RadioButton Dado6;
    private RadioButton Dado8;
    private RadioButton Dado10;
    private RadioButton Dado12;
    private RadioButton Dado20;
    private RadioButton Dado100;
    private Spinner spnQtDado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Dado4 = findViewById(R.id.Dado4);
        Dado6 = findViewById(R.id.Dado6);
        Dado6.setChecked(true);
        Dado8 = findViewById(R.id.Dado8);
        Dado10 = findViewById(id.Dado10);
        Dado12 = findViewById(R.id.Dado10);
        Dado20 = findViewById(R.id.Dado20);
        Dado100 = findViewById(R.id.Dado100);
        spnQtDado = findViewById(R.id.spnQtDado);
        txtRes = findViewById(R.id.txtRes);
        Button btnJogar = findViewById(id.btnJogar);

        preencheSpinner();
        btnJogar.setOnClickListener(op -> gerar());
    }
    private void preencheSpinner() {
        List<Integer> lista = new ArrayList<>();
        for(int i = 1; i <=3; i++) {
            lista.add(i);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnQtDado.setAdapter(adapter);
    }
    private void gerar(){
        StringBuilder buffer = new StringBuilder();
        Integer qtd = (Integer) spnQtDado.getSelectedItem();
        int facesDado = 0;
        if (Dado4.isChecked()){
            facesDado = 4;
        } else if (Dado6.isChecked()){
            facesDado = 6;
        } else if(Dado8.isChecked()){
            facesDado = 8;
        } else if (Dado10.isChecked()){
          facesDado = 10;
        } else if (Dado12.isChecked()){
            facesDado = 12;
        } else if (Dado20.isChecked()){
            facesDado = 20;
        } else if (Dado100.isChecked()){
            facesDado = 100;
        }

        for (int i = 1; i <= qtd; i++){
            int resultado = (int) (Math.random()* facesDado) + 1;
            String res = "Dado: " +facesDado+ "\nResultado:  " +resultado;
            buffer.append(res);

        }

        txtRes.setText(buffer.toString());
    }
}