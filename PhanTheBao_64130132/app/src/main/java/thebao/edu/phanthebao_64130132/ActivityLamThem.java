package thebao.edu.phanthebao_64130132;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLamThem extends AppCompatActivity {
    private EditText heightInput, weightInput;
    private TextView resultText, categoryText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Button calculateButton;
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        resultText = findViewById(R.id.resultText);
        categoryText = findViewById(R.id.categoryText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr) / 100; // Chuyển đổi chiều cao từ cm sang m
            float weight = Float.parseFloat(weightStr);

            float bmi = weight / (height * height);

            resultText.setText(String.format("BMI của bạn: %.2f", bmi));
            categoryText.setText(getBMICategory(bmi));
        } else {
            resultText.setText("Vui lòng nhập đầy đủ chiều cao và cân nặng");
            categoryText.setText("");
        }
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) {
            return "Thiếu cân";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Cân đối";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Thừa cân";
        } else {
            return "Béo phì";
        }
    }
}