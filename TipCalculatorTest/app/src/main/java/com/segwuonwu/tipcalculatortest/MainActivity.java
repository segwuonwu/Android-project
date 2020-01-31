package com.segwuonwu.tipcalculatortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText enterAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekbar;
    private  int seekbarPercentage;
    private float enteredBillFloat;
    private TextView totalBillTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount = findViewById(R.id.billAmountID);
        seekBar = findViewById(R.id.persentageSeekBar);
        calculateButton = findViewById(R.id.calculateButton);
        totalResultTextView = findViewById(R.id.resultID);
        textViewSeekbar = findViewById(R.id.textViewSeekbar);
        totalBillTv = findViewById(R.id.totalBillTextView);


        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekbar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercentage = seekBar.getProgress();

            }
        });
    }

    @Override
    public void onClick(View v) {
        calculate();
    }

    public void calculate(){
        float result = 0.0f;
        DecimalFormat df = new DecimalFormat("#.##");

        if(!enterAmount.getText().toString().equals("")){
            enteredBillFloat = Float.parseFloat(enterAmount.getText().toString());
            result = enteredBillFloat * seekbarPercentage / 100;
            totalResultTextView.setText("Your tip will be " + "$"+ String.valueOf(df.format(result)));
            totalBillTv.setText("Total bill: " + "$" + String.valueOf(df.format(enteredBillFloat + result)));

            //Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }

    }
}
