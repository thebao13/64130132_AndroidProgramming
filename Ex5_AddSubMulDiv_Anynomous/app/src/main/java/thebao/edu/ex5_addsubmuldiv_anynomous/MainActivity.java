package thebao.edu.ex5_addsubmuldiv_anynomous;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextSo3;
    Button nutCong,nutTru,nutNhan,nutChia;
    void TimDieuKhien() {
        editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        editTextSo2 = (EditText) findViewById(R.id.edtSo2);
        editTextSo3 = (EditText) findViewById(R.id.edtKetQua);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }


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
        TimDieuKhien();
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextSo1= (EditText)findViewById(R.id.edtSo1);
                EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

                String soThu1 = editTextSo1.getText().toString();
                String soThu2 = editTextSo2.getText().toString();

                float SoA = Float.parseFloat(soThu1);
                float SoB = Float.parseFloat(soThu2);

                float Tong  = SoA + SoB;

                EditText editTextKQ = (EditText)findViewById(R.id.edtKetQua);

                String chuoiKQ = String.valueOf(Tong);

                editTextKQ.setText(chuoiKQ);
            }
        });
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextSo1= (EditText)findViewById(R.id.edtSo1);
                EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

                String soThu1 = editTextSo1.getText().toString();
                String soThu2 = editTextSo2.getText().toString();

                float SoA = Float.parseFloat(soThu1);
                float SoB = Float.parseFloat(soThu2);

                float Tong  = SoA - SoB;

                EditText editTextKQ = (EditText)findViewById(R.id.edtKetQua);

                String chuoiKQ = String.valueOf(Tong);

                editTextKQ.setText(chuoiKQ);
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextSo1= (EditText)findViewById(R.id.edtSo1);
                EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

                String soThu1 = editTextSo1.getText().toString();
                String soThu2 = editTextSo2.getText().toString();

                float SoA = Float.parseFloat(soThu1);
                float SoB = Float.parseFloat(soThu2);

                float Tong  = SoA  * SoB;

                EditText editTextKQ = (EditText)findViewById(R.id.edtKetQua);

                String chuoiKQ = String.valueOf(Tong);

                editTextKQ.setText(chuoiKQ);
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextSo1= (EditText)findViewById(R.id.edtSo1);
                EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);

                String soThu1 = editTextSo1.getText().toString();
                String soThu2 = editTextSo2.getText().toString();

                float SoA = Float.parseFloat(soThu1);
                float SoB = Float.parseFloat(soThu2);

                float Tong  = SoA / SoB;

                EditText editTextKQ = (EditText)findViewById(R.id.edtKetQua);

                String chuoiKQ = String.valueOf(Tong);

                editTextKQ.setText(chuoiKQ);
            }
        });

    }
}