package br.com.flores.marcio.loccarr;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ExclusaoMotorista extends AppCompatActivity {
    EditText editCnh;
    String cnh;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusao_motorista);

        editCnh = findViewById(R.id.editCnh);
    }

    public void excluir (View view){

        databaseReference = FirebaseDatabase.getInstance().getReference("Motorista");

        //String nome = databaseReference.

        cnh = editCnh.getText().toString().trim();

        Query query = databaseReference.orderByChild("Motorista").equalTo(cnh);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    databaseReference.removeValue();
                    Toast.makeText(ExclusaoMotorista.this, "Motorista excluído.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ExclusaoMotorista.this, "Não foi possível excluir o motorista. Confira a CNH.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
