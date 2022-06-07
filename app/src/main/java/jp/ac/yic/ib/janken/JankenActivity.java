package jp.ac.yic.ib.janken;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class JankenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janken);

        // インテント取得
        Intent intent = getIntent();

        // 出す手を取得
        String myHand = intent.getStringExtra("pushed");

        // コンピュータの出す手をランダムに取得
        Random r = new Random();
        int numOfCpuHand = r.nextInt(3);
        String cpuHand = "";
        switch (numOfCpuHand) {
            case 0:
                cpuHand = "gu";
                break;
            case 1:
                cpuHand = "pa";
                break;
            case 2:
                cpuHand = "tyoki";
        }

        // 自分の手を表示
        ImageView myImg = findViewById(R.id.imgview_me);
        switch (myHand) {
            case "gu":
                myImg.setImageResource(R.drawable.gu_me);
                break;
            case "pa":
                myImg.setImageResource(R.drawable.pa_me);
                break;
            case "tyoki":
                myImg.setImageResource(R.drawable.tyoki_me);
        }

        // コンピュータの手を表示
        ImageView cpuImg = findViewById(R.id.imgview_cpu);
        switch (cpuHand) {
            case "gu":
                cpuImg.setImageResource(R.drawable.gu_cpu);
                break;
            case "pa":
                cpuImg.setImageResource(R.drawable.pa_cpu);
                break;
            case "tyoki":
                cpuImg.setImageResource(R.drawable.tyoki_cpu);
        }


        // 勝敗を判定して表示
        TextView txt_result = findViewById(R.id.txt_result);

        if (myHand.equals("gu")) {
            switch (cpuHand) {
                case "gu":
                    draw(txt_result);
                    break;
                case "pa":
                    lose(txt_result);
                    break;
                case "tyoki":
                    win(txt_result);
                    break;
            }
        } else if (myHand.equals("pa")) {
            switch (cpuHand) {
                case "gu":
                    win(txt_result);
                    break;
                case "pa":
                    draw(txt_result);
                    break;
                case "tyoki":
                    lose(txt_result);
                    break;
            }
        } else {
            switch (cpuHand) {
                case "gu":
                    lose(txt_result);
                    break;
                case "pa":
                    win(txt_result);
                    break;
                case "tyoki":
                    draw(txt_result);
                    break;
            }
        }


        //if (myHand.equals("tyoki"))
        // Againボタンの挙動
        Button btn_again = findViewById(R.id.btn_again);
        btn_again.setOnClickListener(view -> finish());

    }

    @SuppressLint("SetTextI18n")
    private void win(TextView txt_result) {
        txt_result.setText("WIN!!");
        txt_result.setTextColor(Color.rgb(255, 127, 0));
    }
    @SuppressLint("SetTextI18n")
    private void lose(TextView txt_result) {
        txt_result.setText("LOSE...");
        txt_result.setTextColor(Color.rgb(0, 0, 127));
    }
    @SuppressLint("SetTextI18n")
    private void draw(TextView txt_result) {
        txt_result.setText("DRAW");
        txt_result.setTextColor(Color.rgb(0, 127, 0));
    }

}