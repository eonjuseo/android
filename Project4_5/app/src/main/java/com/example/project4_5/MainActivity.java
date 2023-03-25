package com.example.project4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1;
    ImageView iv2;
    Button button01;
    Button button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);

        button01 = findViewById(R.id.button1);
        button02 = findViewById(R.id.button2);

      button01.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick (View view)
        {
            moveUp();
        }
        });

        button02.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick (View view)
        {
            moveDown();
        }
        });
    }

    private void moveDown() {
        iv1.setImageResource(0);
        iv2.setImageResource(R.drawable.image01);

        iv1.invalidate();
        iv2.invalidate();

    }

    private void moveUp() {
        iv1.setImageResource(R.drawable.image02);
        iv2.setImageResource(0);

        iv1.invalidate();
        iv2.invalidate();
    }
}