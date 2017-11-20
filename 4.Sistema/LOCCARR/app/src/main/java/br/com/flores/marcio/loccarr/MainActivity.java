package br.com.flores.marcio.loccarr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText editMail, editSenha;
    String mail, senha;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMail = findViewById(R.id.editMail);
        editSenha = findViewById(R.id.editSenha);

        progressDialog = new ProgressDialog(this);
    }

    public void entrar(View view){
        mail = editMail.getText().toString().trim();
        senha = editSenha.getText().toString().trim();

        if (TextUtils.isEmpty(mail)){
            Toast.makeText(this, "E-mail inválido.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(senha)){
            Toast.makeText(this, "Senha inválida.", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Entrando...");
        progressDialog.show();

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword(mail, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            progressDialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), Dashboard.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Usuário/senha inválidos.", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });
    }
}
