package thebao.edu.phanthebao_64130132;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityChucNang4 extends AppCompatActivity {
    LandScapeAdapter adapter;
    ArrayList<LandScape> listDataLand;
    RecyclerView recyclerViewLandscape;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuc_nang4);
        listDataLand = getLandScapeData();
        //b4
        recyclerViewLandscape = findViewById(R.id.recyclerLand);
        //b5
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this  );
        recyclerViewLandscape.setLayoutManager(layoutManager);


        //b6
        adapter = new LandScapeAdapter(this, listDataLand);
        //b7
        recyclerViewLandscape.setAdapter(adapter);
    }
    ArrayList<LandScape> getLandScapeData() {
        ArrayList<LandScape> listData = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape(R.mipmap.ngaytruyenthong,"80 năm ","22/12/2024");
        listData.add(landScape1);
        listData.add(new LandScape(R.mipmap.dangcongsan, "Chào Mùng đảng cộng sản","26/03/2025"));
        listData.add(new LandScape(R.mipmap.quoctephunu, "Chào Mùng Quốc tế Phụ Nữ","8/03/2025"));
        return listData;
    }
}
