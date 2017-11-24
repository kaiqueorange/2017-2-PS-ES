package br.com.flores.marcio.loccarr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void manterMotorista (View view){
        startActivity(new Intent(getApplicationContext(), ManterMotorista.class));
    }
}
