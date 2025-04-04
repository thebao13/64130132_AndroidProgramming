package thebao.edu.phanthebao_64130132;

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
    Button btncn2,btncn3,btncn4,btnaboutme,btnlamthem;
    void TimKiem(){
        btncn2 = (Button) findViewById(R.id.btncn2);
        btncn3 = (Button) findViewById(R.id.btncn3);
        btncn4 = (Button) findViewById(R.id.btncn4);
        btnaboutme = (Button) findViewById(R.id.btnaboutme);
        btnlamthem = (Button) findViewById(R.id.btnlamthem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimKiem();
        btncn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChucNang2 = new Intent(MainActivity.this, ActivityChucNang2.class);
                startActivity(ChucNang2);
            }
        });
        btncn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChucNang3 = new Intent(MainActivity.this, ActivityChucNang33.class);
                startActivity(ChucNang3);
            }
        });
        btncn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChucNang4 = new Intent(MainActivity.this, ActivityChucNang4.class);
                startActivity(ChucNang4);
            }
        });
        btnaboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AboutMe = new Intent(MainActivity.this, ActivityAboutMe.class);
                startActivity(AboutMe);
            }
        });
        btnlamthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LamThem = new Intent(MainActivity.this, ActivityLamThem.class);
                startActivity(LamThem);
            }
        });
    }
}