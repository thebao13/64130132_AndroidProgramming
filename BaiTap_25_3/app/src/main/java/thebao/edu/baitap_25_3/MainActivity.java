package thebao.edu.baitap_25_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String Hoa[] ={"Hoa Mai","Hoa Đào", "Hoa Huệ", "Hoa Hồng", "Hoa Cúc"};
    TextView txt_select;
    ArrayAdapter<String> myadapter;
    ListView    lvHoa;
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
        txt_select = findViewById(R.id.tvHienthi);
        lvHoa = findViewById(R.id.lvHoa);
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, Hoa);
        lvHoa.setAdapter(myadapter);
        lvHoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    txt_select.setText(Hoa[position]);
                    Toast.makeText(MainActivity.this,"Bạn đã chọn: " +Hoa[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}