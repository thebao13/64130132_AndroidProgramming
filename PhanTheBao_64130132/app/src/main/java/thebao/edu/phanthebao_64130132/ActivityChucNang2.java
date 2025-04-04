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

public class ActivityChucNang2 extends AppCompatActivity {
    EditText edtngay,edtthang,edtnam;
    Button btnkiemtra;
    TextView hienthi;
    void TimKiem(){
        edtngay = (EditText) findViewById(R.id.edtngay);
        edtthang = (EditText) findViewById(R.id.edtthang);
        edtnam = (EditText) findViewById(R.id.edtnam);
        btnkiemtra = (Button) findViewById(R.id.btnkiemtra);
        hienthi = (TextView) findViewById(R.id.hienthi);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuc_nang2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TimKiem();
    }
        public void KiemTra(View view ) {
            int ngay = Integer.parseInt(edtngay.getText().toString());
            int thang = Integer.parseInt(edtthang.getText().toString());
            int nam = Integer.parseInt(edtnam.getText().toString());
            if(ngay == 30 && thang == 4 && nam == 1975){
                hienthi.setText("Đúng");
            }else{
                hienthi.setText("Sai");
            }
    }
}
