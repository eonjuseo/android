package com.example.project4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.project4_4.R;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch swtAgree;
    RadioGroup rGroup1;
    RadioButton rdooreo, rdopie, rdoq;
    Button btnend, btnsrt;
    ImageView imgos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1=(TextView) findViewById(R.id.Text1);
        swtAgree=(Switch) findViewById(R.id.SwtAgree);
        text2=(TextView) findViewById(R.id.Text2);
        rGroup1=(RadioGroup)findViewById(R.id.Rgroup1);
        rdooreo=(RadioButton)findViewById(R.id.RdoOreo);
        rdopie=(RadioButton)findViewById(R.id.RdoPie);
        rdoq=(RadioButton)findViewById(R.id.RdoQ);
        btnend=(Button)findViewById(R.id.btnEnd);
        btnsrt=(Button)findViewById(R.id.btnSrt);

        imgos=(ImageView)findViewById(R.id.ImgOS);

        swtAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swtAgree.isChecked()==true)
                {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnend.setVisibility(View.VISIBLE);
                    btnsrt.setVisibility(View.VISIBLE);
                    imgos.setVisibility(View.VISIBLE);
                }
                else
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnend.setVisibility(View.INVISIBLE);
                    btnsrt.setVisibility(View.INVISIBLE);
                    imgos.setVisibility(View.INVISIBLE);
                }
            }
        });
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = rGroup1.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.RdoOreo) {
                    imgos.setImageResource(R.drawable.oreo);
                } else if (checkedRadioButtonId == R.id.RdoPie) {
                    imgos.setImageResource(R.drawable.pie);
                } else if (checkedRadioButtonId == R.id.RdoQ) {
                    imgos.setImageResource(R.drawable.q);
                }
            }
        });
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
        btnsrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swtAgree.setChecked(false);
            }
        });
    }
}