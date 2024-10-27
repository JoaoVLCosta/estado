package br.edu.fateczl.estado;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class Exibir extends AppCompatActivity {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private TextView tvShow;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibir);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        tvShow = findViewById(R.id.tvShow);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(op -> voltar());

        assert bundle != null;
        Pessoa pessoa = new Pessoa(bundle.getString("nome"), bundle.getString("cpf"));
        estado(pessoa);
    }

    private void estado(Pessoa pessoa){
        String retorno = getText(R.string.txt_exibir) + "\n" + pessoa.identificarEstado();
        tvShow.setText(retorno);
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }

}