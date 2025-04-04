package thebao.edu.phanthebao_64130132;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityChucNang33 extends AppCompatActivity {
    ListView LvBaiHat;
    ArrayList<String> dsBaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuc_nang33);
        LvBaiHat = (ListView) findViewById(R.id.listbaihat);
        dsBaiHat = new ArrayList<>();
        dsBaiHat.add("Giải phóng miền Nam");
        dsBaiHat.add("Tiến về Sài Gòn");
        dsBaiHat.add("Như có Bác trong ngày đại thắng");
        dsBaiHat.add("Đất nước trọn niềm vui");
        dsBaiHat.add("Bài ca thống nhất");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsBaiHat);
        LvBaiHat.setAdapter(adapter);
        LvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String baihat = dsBaiHat.get(position);
                Toast.makeText(ActivityChucNang33.this, baihat, Toast.LENGTH_SHORT).show();
            }
        });
    }
}