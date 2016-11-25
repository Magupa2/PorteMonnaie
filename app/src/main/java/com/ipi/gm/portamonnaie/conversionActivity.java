package com.ipi.gm.portamonnaie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class conversionActivity extends AppCompatActivity {

    private Spinner spinDeviseActuel;
    private Spinner spinDeviseDemande;
    EditText montantAConvertir;
    private double taux;       //EUR/GBP/CNY/USD
    double[][] tauxChange= {{1,0.8508,7.32106,1.0618}, //EUR
                            {1.1752,1,8.60030,1.2479}, //GBP
                            {0.1367,0.11627,1,0.14510}, //CNY
                            {0.9417,0.8014,6.89198,1}}; //USD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);


        spinDeviseActuel= (Spinner) findViewById(R.id.spinDeviseActuel);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.devises_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDeviseActuel.setAdapter(adapter);
        spinDeviseActuel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        spinDeviseDemande= (Spinner) findViewById(R.id.spinDeviseDemande);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.devises_array));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDeviseDemande.setAdapter(adapter2);
        spinDeviseDemande.setSelection(1);
        spinDeviseDemande.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Intent intent = getIntent();
        String montantDeConsultation = intent.getStringExtra(consultationActivity.EXTRA_MESSAGE);
        montantAConvertir = (EditText) findViewById(R.id.montantAConvertir);
        montantAConvertir.setText(montantDeConsultation);
    }

    public double conversion(double montant, double tauxDeChange)
    {
        return montant*tauxDeChange;
    }

    public double tauxDeChange(int y, int x)
    {
        return tauxChange[y][x];
    }

    public void Traitement(View v){
        double montant = Double.parseDouble(montantAConvertir.getText().toString());
        double MontantDemander = conversion(montant,tauxDeChange(spinDeviseActuel.getSelectedItemPosition(),spinDeviseDemande.getSelectedItemPosition()));

        Toast toast = Toast.makeText(conversionActivity.this,""+MontantDemander, Toast.LENGTH_LONG);
        toast.show();
    }


}
