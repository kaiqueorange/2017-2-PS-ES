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

public class Cadastrar extends AppCompatActivity {
    EditText editMail, editSenha, editSenhaConfirmacao;
    String mail, senha, senhaConfirmacao;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editMail = findViewById(R.id.editMail);
        editSenha = findViewById(R.id.editSenha);
        editSenhaConfirmacao = findViewById(R.id.editSenhaConfirmacao);

        progressDialog = new ProgressDialog(this);
    }

    public void cadastro (View view){
        mail = editMail.getText().toString().trim();
        senha = editSenha.getText().toString().trim();
        senhaConfirmacao = editSenhaConfirmacao.getText().toString().trim();

        if (TextUtils.isEmpty(mail)){
            Toast.makeText(this, "E-mail inválido.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(senha)){
            Toast.makeText(this, "Senha inválida.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(senhaConfirmacao)){
            Toast.makeText(this, "Senha inválida.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!TextUtils.equals(senha, senhaConfirmacao)){
            Toast.makeText(this, "As senhas não conferem.", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Cadastrando...");
        progressDialog.show();;

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.createUserWithEmailAndPassword(mail, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Cadastrar.this, "Cadastro realizado com sucesso.", Toast.LENGTH_SHORT).show();
                            finish();
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), Dashboard.class));
                        } else {
                            Toast.makeText(Cadastrar.this, "Não foi possível realizar o cadastro.", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });

    }
}
