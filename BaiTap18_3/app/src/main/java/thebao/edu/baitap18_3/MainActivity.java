package thebao.edu.baitap18_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSo1,btnSo2,btnSo3,btnSo4,btnSo5,btnSo6,btnSo7,btnSo8,btnSo9;
    TextView tvHienthi;
    public void TimDieuKhien(){
        btnSo1 = (Button)findViewById(R.id.btn1);
        btnSo2 = (Button)findViewById(R.id.btn2);
        btnSo3 = (Button)findViewById(R.id.btn3);
        btnSo4 = (Button)findViewById(R.id.btn4);
        btnSo5 = (Button)findViewById(R.id.btn5);
        btnSo6 = (Button)findViewById(R.id.btn6);
        btnSo7 = (Button)findViewById(R.id.btn7);
        btnSo8 = (Button)findViewById(R.id.btn8);
        btnSo9 = (Button)findViewById(R.id.btn9);

        tvHienthi = (TextView)findViewById(R.id.tvHienthi);
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
        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("1");
            }
        });
        btnSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("2");
            }
        });
        btnSo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("3");
            }
        });
        btnSo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("4");
            }
        });
        btnSo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("5");
            }
        });
        btnSo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("6");
            }
        });
        btnSo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("7");
            }
        });
        btnSo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("8");
            }
        });
        btnSo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienthi.setText("9");
            }
        });

    }
}