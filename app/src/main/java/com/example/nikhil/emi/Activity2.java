package com.example.nikhil.emi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //Creating Intent to fetch data------
        Intent i = getIntent();

        //Collecting values from FirstActivity--------
        final String p = i.getStringExtra("principal");
        TextView textView = (TextView)findViewById(R.id.principal);
        textView.setText(p);

        final String r = i.getStringExtra("tpi");
        TextView textView2 = (TextView)findViewById(R.id.tpi);
        textView2.setText(r);

        final String emi = i.getStringExtra("emi");
        TextView textView3 = (TextView)findViewById(R.id.emi2);
        textView3.setText(emi);

        //Creating a Button for sharing records-------
        Button b = (Button)findViewById(R.id.share);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String EMI = "*EMI Amount* = "+emi+"\n*Principal Amount* = "+p+"\n*Total Payable Interest* = "+r;
                i.putExtra(Intent.EXTRA_TEXT,EMI);
                startActivity(Intent.createChooser(i,"Share Using"));
            }
        });
    }
}
