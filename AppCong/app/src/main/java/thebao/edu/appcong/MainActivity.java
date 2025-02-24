package thebao.edu.appcong;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
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
    public void XulyCong(View view){
        EditText SoA = findViewById(R.id.etdA);
        EditText SoB = findViewById(R.id.edtB);
        EditText kq = findViewById(R.id.edtKq);
        //lấy dữ liệu ở điều khiển về số A
        String strA = SoA.getText().toString();
        //lấy dữ liệu ở điều khiển về số A
        String strB = SoB.getText().toString();

        // chuyển dữ liệu sang dạng số
        int So_A = Integer.parseInt(strA);
        // chuyển dữ liệu sang dạng số
        int So_B = Integer.parseInt(strB);



        // tính tổng
        int Tong = So_A + So_B;
        // hiện ra màn hình
        //trước khi hiện th chuyển nó về dạng chuỗi để có thể hiện
        String  strTong = String.valueOf(Tong);


        kq.setText(strTong);
    }
}