package edu.fpt.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private Button calculateBtn;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        calculateBtn = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result();
            }
        });
    }

    private void Result() {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double c = Double.parseDouble(editTextC.getText().toString());

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            resultTextView.setText("PT có 2 nghiệm:\nX1 = " + x1 + "\nX2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            resultTextView.setText("PT có nghiệm kép:\nX = " + x);
        } else {
            resultTextView.setText("Phương trình vô nghiệm.");
        }
    }
}