package jp.ac.yic.ib.janken;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imgbtn_gu = findViewById(R.id.imgbtn_gu);
        ImageButton imgbtn_pa = findViewById(R.id.imgbtn_pa);
        ImageButton imgbtn_tyoki = findViewById(R.id.imgbtn_tyoki);

        imgbtn_gu.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JankenActivity.class);
            intent.putExtra("pushed", "gu");
            startActivity(intent);
        });

        imgbtn_pa.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JankenActivity.class);
            intent.putExtra("pushed", "pa");
            startActivity(intent);
        });

        imgbtn_tyoki.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JankenActivity.class);
            intent.putExtra("pushed", "tyoki");
            startActivity(intent);
        });

        }

    }
