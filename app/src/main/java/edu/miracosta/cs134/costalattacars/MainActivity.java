package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate references
        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);
    }

    public void generateReport(View v)
    {
        double carPrice, downPayment;
        try {
            carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        }
        catch(NumberFormatException e)
        {
            carPrice = 0;
        }

        try
        {
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        catch(NumberFormatException e)
        {
            downPayment = 0;
        }

        int loanTerm = getYearsValue();

        // Let's instantiate the Intent and navigate to LoanSummaryActivity
        Intent intent = new Intent(this, LoanSummaryActivity.class);
        intent.putExtra("CarPrice", carPrice);
        intent.putExtra("DownPayment", downPayment);
        intent.putExtra("LoanTerm", loanTerm);

        startActivity(intent);
    }


    private int getYearsValue()
    {
        int years = 0;

        switch (loanTermRadioGroup.getCheckedRadioButtonId())
        {
            case R.id.threeYearsRadioButton:
                years =  3;
                break;

            case R.id.fourYearsRadioButton:
                years = 4;
                break;

            case R.id.fiveYearsRadioButton:
                years = 5;
                break;

                default:
                years =  5;
                break;
        }
            return years;

    }

}
