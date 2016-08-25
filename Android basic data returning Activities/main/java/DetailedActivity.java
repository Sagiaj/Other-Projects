package com.example.sagi.datapass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DetailedActivity extends AppCompatActivity {

    private Button ReturnButton = null;
    private Spinner spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed);

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            String detailValue = extras.getString("KeyForSending");
            if(detailValue!=null){
                Toast.makeText(this,detailValue,Toast.LENGTH_SHORT).show();
            }
        }

        spinner = (Spinner) findViewById(R.id.detailedSpinner);

        ReturnButton = (Button) findViewById(R.id.returnToSecond);
        ReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                String mySelection = spinner.getSelectedItem().toString();
                returnIntent.putExtra("KeyForReturning",mySelection);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}
