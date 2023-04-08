package com.example.oneapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oneapplication.view.M2Dia;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener clo;
    private View.OnClickListener con;
    private M2Dia m2Dia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Close Button
        clo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click the close button", Toast.LENGTH_SHORT).show();
                m2Dia.dismiss();
            }
        };
        // Confirm Button
        con = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click the confirm button", Toast.LENGTH_SHORT).show();
                m2Dia.dismiss();
            }
        };


        // 所有按钮都有
        LinearLayout suc = findViewById(R.id.suc);
        suc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View v) {

                M2Dia.createSuccess(MainActivity.this, getString(R.string.success_title), M2Dia.M2ButTpe.HAVE_ALL_BUT)
                        .setContent(getString(R.string.context)) // set the context , default null
                        .setConfirmClick(con) // confirm button click , default dismiss
                        .setCloseClick(clo) // close button click , default dismiss
                        .setConfirmButText("confirm T") // confirm button text , default "confirm"
                        .setCloseButText("close T") // close button text , default "close"
                        .setLottieJson(M2Dia.M2Type.SUCCESS, "success.json") // custom lottie , default success.json
                        .setRepeatCount(5) // lottie count ,if 0 then only play 1 , default 0
                        .setCancelables(false) // Allow closing by clicking the return button , default true
                        .setCanceledOnTouchOutsides(false) // Allow closing by clicking on the screen , default true
                        .showM2(); // show the dialog
            }
        });
        LinearLayout err = findViewById(R.id.err);
        err.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2Dia = M2Dia.createError(MainActivity.this, getString(R.string.error_title), M2Dia.M2ButTpe.HAVE_ALL_BUT)
                        .setContent(getString(R.string.context))
                        .setRepeatCount(5)
                        .setCloseClick(clo)
                        .showM2();
            }
        });
        LinearLayout war = findViewById(R.id.war);
        war.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2Dia = M2Dia.createWarning(MainActivity.this, getString(R.string.warning_title), M2Dia.M2ButTpe.HAVE_ALL_BUT)
                        .setCloseButText("custom T")
                        .showM2();
            }
        });


        // 无 取消 按钮
        LinearLayout sucS = findViewById(R.id.sucS);
        sucS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2Dia = M2Dia.createSuccess(MainActivity.this, getString(R.string.success_title), M2Dia.M2ButTpe.NO_CLOSE_BUT)
                        .setCloseButText("NOBut")
                        .setConfirmButText("YESBut")
                        .showM2();
            }
        });
        LinearLayout errS = findViewById(R.id.errS);
        errS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2Dia = M2Dia.createError(MainActivity.this, getString(R.string.error_title), M2Dia.M2ButTpe.NO_CLOSE_BUT)
                        .setContent(getString(R.string.context))
                        .showM2();
            }
        });
        LinearLayout warS = findViewById(R.id.warS);
        warS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2Dia = M2Dia.createWarning(MainActivity.this, getString(R.string.warning_title), M2Dia.M2ButTpe.NO_CLOSE_BUT)
                        .setConfirmClick(con)
                        .showM2();
            }
        });
    }
}