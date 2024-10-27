package br.edu.fateczl.estado;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private EditText etNome;
    private EditText etCPF;
    private Button btnID;
    private TextView tvAviso;

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

        etNome = findViewById(R.id.etNome);
        etCPF = findViewById(R.id.etCPF);
        tvAviso = findViewById(R.id.tvAviso);

        btnID = findViewById(R.id.btnID);
        btnID.setOnClickListener(op -> identificar());
    }

    private void identificar() {
        Bundle bundle = new Bundle();
        String cpf = etCPF.getText().toString();
        if(cpf.length() != 11){
            tvAviso.setText(getText(R.string.txt_aviso));
        } else {
            bundle.putString("nome", etNome.getText().toString());
            bundle.putString("cpf", cpf);
            mudar(bundle);
        }
    }

    private void mudar(Bundle bundle) {
        Intent i = new Intent(this, Exibir.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }

}