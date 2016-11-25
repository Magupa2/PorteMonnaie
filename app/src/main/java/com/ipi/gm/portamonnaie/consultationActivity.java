package com.ipi.gm.portamonnaie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class consultationActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.ipi.gm.portamonnaie.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);
    }
    public void transfert_conversion_eur(View view) {
        Intent intent = new Intent(this, conversionActivity.class);
        TextView textView = (TextView) findViewById(R.id.montant_eur);
        String montant = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, montant);
        startActivity(intent);
    }
    
    public void transfert_conversion_usd(View view) {
        Intent intent = new Intent(this, conversionActivity.class);
        TextView textView = (TextView) findViewById(R.id.montant_usd);
        String montant = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, montant);
        startActivity(intent);
    }

    public void transfert_conversion_gbp(View view) {
        Intent intent = new Intent(this, conversionActivity.class);
        TextView textView = (TextView) findViewById(R.id.montant_gbp);
        String montant = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, montant);
        startActivity(intent);
    }public void transfert_conversion_cny(View view) {
        Intent intent = new Intent(this, conversionActivity.class);
        TextView textView = (TextView) findViewById(R.id.montant_cny);
        String montant = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, montant);
        startActivity(intent);
    }
    public void GoToGestion(View view){
        Intent intent = new Intent(this, gestionActivity.class);
        startActivity(intent);
    }
}
