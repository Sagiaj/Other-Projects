package com.example.sagi.datapass;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    public static final int DETAIL_REQUEST = 1;

    private Button bDetailed = null;
    private Button button = null;
    private TextView vSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        vSelected = (TextView) findViewById(R.id.userSelection);

        button = (Button) findViewById(R.id.goToFirst);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });

        bDetailed = (Button) findViewById(R.id.goToDetailed);
        bDetailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DetailedActivity.class);
                i.putExtra("KeyForSending","Data from SecondActivity");
                startActivityForResult(i,DETAIL_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        if(resultCode==RESULT_OK && requestCode == DETAIL_REQUEST){
            if(data.hasExtra("KeyForReturning")){
                String myValue = data.getExtras().getString("KeyForReturning");
                vSelected.setText(myValue);
            }

        }


    }

}
