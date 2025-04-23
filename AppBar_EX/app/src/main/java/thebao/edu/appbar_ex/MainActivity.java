package thebao.edu.appbar_ex;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //tìm điều khiển
        bottomNav = findViewById(R.id.bot_nav);

        //lắng nghe điều kieen
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuItemDuocChon =  item.getItemId();
                if (menuItemDuocChon == R.id.menu_home) {
                    Toast.makeText(MainActivity.this, "Thay Home", Toast.LENGTH_LONG).show();
                }
                else if (menuItemDuocChon == R.id.menu_profile){
                    Toast.makeText(MainActivity.this, "Profile ", Toast.LENGTH_LONG).show();
                }
                    else if (menuItemDuocChon == R.id.menu_search){
                    Toast.makeText(MainActivity.this, "Search ", Toast.LENGTH_LONG).show();
                }
                        else return true;
                return false;

            }
        });

    }
}