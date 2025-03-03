package thebao.edu.unitconverter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner inputUnitSpinner, outputUnitSpinner;
    private TextView resultText;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        inputUnitSpinner = findViewById(R.id.inputUnitSpinner);
        outputUnitSpinner = findViewById(R.id.outputUnitSpinner);
        resultText = findViewById(R.id.resultText);
        convertButton = findViewById(R.id.convertButton);

        // Thiết lập dữ liệu cho Spinner
        setupSpinners();

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void setupSpinners() {
        // Danh sách đơn vị đo
        String[] units = {"mm", "cm", "dm", "m", "km"};

        // Tạo Adapter cho Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gán Adapter cho Spinner
        inputUnitSpinner.setAdapter(adapter);
        outputUnitSpinner.setAdapter(adapter);
    }

    private void convertUnits() {
        String inputValueStr = inputValue.getText().toString();

        if (!inputValueStr.isEmpty()) {
            double value = Double.parseDouble(inputValueStr);
            String inputUnit = inputUnitSpinner.getSelectedItem().toString();
            String outputUnit = outputUnitSpinner.getSelectedItem().toString();

            // Chuyển đổi giá trị về đơn vị cơ bản (mét)
            double valueInMeters = convertToMeters(value, inputUnit);

            // Chuyển đổi từ mét sang đơn vị đầu ra
            double result = convertFromMeters(valueInMeters, outputUnit);

            // Hiển thị kết quả
            resultText.setText(String.format("%.2f %s = %.2f %s", value, inputUnit, result, outputUnit));
        } else {
            resultText.setText("Vui lòng nhập giá trị cần chuyển đổi");
        }
    }

    private double convertToMeters(double value, String unit) {
        switch (unit) {
            case "mm":
                return value / 1000;
            case "cm":
                return value / 100;
            case "dm":
                return value / 10;
            case "m":
                return value;
            case "km":
                return value * 1000;
            default:
                return value;
        }
    }

    private double convertFromMeters(double valueInMeters, String unit) {
        switch (unit) {
            case "mm":
                return valueInMeters * 1000;
            case "cm":
                return valueInMeters * 100;
            case "dm":
                return valueInMeters * 10;
            case "m":
                return valueInMeters;
            case "km":
                return valueInMeters / 1000;
            default:
                return valueInMeters;
        }
    }
}