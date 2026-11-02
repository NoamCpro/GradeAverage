package com.example.gradeaverage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etGrade1 = findViewById(R.id.etGrade1);
        TextView tvResult = findViewById(R.id.tvResult);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gradeText = etGrade1.getText().toString();
                if (gradeText.isEmpty()) {
                    etGrade1.setError("חובה למלא ציון");
                    etGrade1.requestFocus();
                    return;
                }

                int grade = Integer.parseInt(gradeText);

                if (grade > 100) {
                    etGrade1.setError("ציון בין 0 ל-100");
                    etGrade1.requestFocus();
                    return;
                }

                tvResult.setText("ציון במתמטיקה: " + grade);
            }
        });


    }
}