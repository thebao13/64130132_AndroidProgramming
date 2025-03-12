package thebao.edu.vd_listview;

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

public class MainActivity extends AppCompatActivity {
        ListView lisviewNNLT;
        ArrayList<String> dsNNLT;
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

        lisviewNNLT = findViewById(R.id.lvNNLT);
        dsNNLT = new ArrayList<String>();
        dsNNLT.add("Python");
        dsNNLT.add("Java");
        dsNNLT.add("C++");
        dsNNLT.add("HTML");
        dsNNLT.add("PHP");
        ArrayAdapter<String> arrayAdapterNNLT;
        arrayAdapterNNLT = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsNNLT);
        lisviewNNLT.setAdapter(arrayAdapterNNLT);
        lisviewNNLT.setOnItemClickListener(new  AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paren, View view, int position, long id) {

                //biến position đã chứa vị trí của item được click
                String giatriduocchon = dsNNLT.get(position);


                // làm theo yêu cầu bất kì đối với giá trị get được/
                Toast.makeText(MainActivity.this, giatriduocchon, Toast.LENGTH_LONG).show();
            }
        });
    }

}