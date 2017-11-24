package br.com.flores.marcio.loccarr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ManterMotorista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_motorista);
    }

    public void cadastrarMotorista (View view){
        startActivity(new Intent(getApplicationContext(), CadastroMotorista.class));
    }

    public void excluirMotorista (View view){
        startActivity(new Intent(getApplicationContext(), ExclusaoMotorista.class));
    }
}
