package com.example.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvToast;
    private Button btn1;
    private EditText etName, etEmail;
    private View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        init();
        initLr();
    }

    public void init(){
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        btn1 = findViewById(R.id.btn1);
    }

    public void initLr(){
        btn1.setOnClickListener(v -> {
            dialogView = View.inflate(MainActivity.this, R.layout.dialog1, null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setIcon(R.drawable.ic_person);
            dlg.setView(dialogView);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    etName = dialogView.findViewById(R.id.etName);
                    etEmail = dialogView.findViewById(R.id.etEmail);

                    tvName.setTextColor(Integer.parseInt(etName.getText().toString()));
                    tvEmail.setTextColor(Integer.parseInt(etEmail.getText().toString()));
                }
            });
            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast toast = new Toast(MainActivity.this);
                    toastView = View.inflate(MainActivity.this, R.layout.toast1, null);
                    tvToast = toastView.findViewById(R.id.tvToast);
                    tvToast.setText("취소했습니다.");
                    toast.setView(toastView);
                    toast.show();
                }
            });
            dlg.show();
        });
    }
}