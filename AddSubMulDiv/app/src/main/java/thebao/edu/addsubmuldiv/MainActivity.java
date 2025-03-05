package thebao.edu.addsubmuldiv;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    }



    public void XuLyCong (View v) {

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
    public void XuLyTru(View v) { // Thêm kiểu trả về 'void' ở đây

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
    public void XuLyNhan (View v) {

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
    public void XuLyChia (View v) {

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



}