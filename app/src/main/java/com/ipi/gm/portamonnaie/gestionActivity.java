package com.ipi.gm.portamonnaie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class gestionActivity extends AppCompatActivity {

    private Spinner spinAjout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        spinAjout= (Spinner) findViewById(R.id.spinAjout);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.devises_array));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAjout.setAdapter(adapter2);
        spinAjout.setSelection(1);
        spinAjout.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void Ajouter(View view){
        String devise = spinAjout.getSelectedItem().toString();
        EditText montant = (EditText) findViewById(R.id.montant_ajouter);
        Toast toast = Toast.makeText(gestionActivity.this,""+montant.getText()+" "+devise+" ajouté", Toast.LENGTH_LONG);
        toast.show();
        finish();
    }

    public void supprimer(View view){
        String devise = spinAjout.getSelectedItem().toString();
        EditText montant = (EditText) findViewById(R.id.montant_ajouter);
        Toast toast = Toast.makeText(gestionActivity.this,""+montant.getText()+" "+devise+" supprimé", Toast.LENGTH_LONG);
        toast.show();
        finish();
    }
}
