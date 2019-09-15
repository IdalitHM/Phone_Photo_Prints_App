package com.example.phonephotoprintsapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double optionOne = 0.19;
    double optionTwo = 0.49;
    double optionThree = 0.79;
    double orderEntered;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final RadioButton fourBySix = (RadioButton) findViewById(R.id.radFourBySix);
        final RadioButton fiveBySeven = (RadioButton) findViewById(R.id.radFiveBySeven);
        final RadioButton eightByTen = (RadioButton) findViewById(R.id.radEightByTen);
        final EditText print = (EditText) findViewById(R.id.txtPrints);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button total = (Button) findViewById(R.id.btnOrder);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderEntered = Double.parseDouble(print.getText().toString());
                DecimalFormat currency = new DecimalFormat("$##.##");
                if(fourBySix.isChecked()) {
                    if(orderEntered <=50) {
                        totalCost = orderEntered * optionOne;
                        result.setText("The order cost is " + currency.format(totalCost));
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot enter more than 50 prints", Toast.LENGTH_LONG).show();
                    }
                }

                if(fiveBySeven.isChecked()) {
                    if(orderEntered <=50) {
                        totalCost = orderEntered * optionTwo;
                        result.setText("The order cost is " + currency.format(totalCost));
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot enter more than 50 prints", Toast.LENGTH_LONG).show();
                    }

                }

                if(eightByTen.isChecked()) {
                    if(orderEntered <=50) {
                        totalCost = orderEntered * optionThree;
                        result.setText("The order cost is " + currency.format(totalCost));
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot enter more than 50 prints", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
