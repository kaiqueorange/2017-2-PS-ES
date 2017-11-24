package br.com.flores.marcio.loccarr;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

import br.com.flores.marcio.loccarr.Modelos.Motorista;

public class CadastroMotorista extends AppCompatActivity {
    EditText editNome, editCnh, editData;
    String nome, cnh, data;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_motorista);

        editNome = findViewById(R.id.editNome);
        editCnh = findViewById(R.id.editCnh);
        editData = findViewById(R.id.editData);
    }

    public void cadastrar (View view){
        nome = editNome.getText().toString().trim();
        cnh = editCnh.getText().toString().trim();
        String matricula = nome+cnh;
        data = editData.getText().toString().trim();

        if(TextUtils.isEmpty(nome)){
            Toast.makeText(this, "O nome não pode estar em branco.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(cnh)){
            Toast.makeText(this, "A CNH não pode estar em branco..", Toast.LENGTH_SHORT).show();
            return;
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Motorista");

        Motorista motorista = new Motorista(nome, cnh, matricula, data);
        databaseReference.child(cnh).setValue(motorista);
        Toast.makeText(this, "Motorista cadastrado.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
