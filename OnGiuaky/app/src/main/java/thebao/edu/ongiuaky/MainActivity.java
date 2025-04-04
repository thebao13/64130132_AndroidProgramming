package thebao.edu.ongiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    public void Cau1(View v){
        Intent iCau1 = new Intent(this, Cau1.class);
        startActivity(iCau1);
    }
    public void Cau2(View v){
        Intent iCau2 = new Intent(this, Cau2.class);
        startActivity(iCau2);
    }
    public void Cau3(View v){
        Intent iCau3 = new Intent(this, Cau3.class);
        startActivity(iCau3);
    }
    public void Cau4(View v){
        Intent iCau4 = new Intent(this, Cau4.class);
        startActivity(iCau4);
    }
}