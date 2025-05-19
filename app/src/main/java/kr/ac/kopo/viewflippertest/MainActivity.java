package kr.ac.kopo.viewflippertest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    ViewFlipper flipper1;

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

        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
        flipper1 = findViewById(R.id.flipper1);

        btnPrev.setOnClickListener(btnLinstener);
        btnNext.setOnClickListener(btnLinstener);
    }

    View.OnClickListener btnLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Button btnEvent = (Button) v;
          if (btnEvent == btnPrev){
              flipper1.showPrevious();
          }else {
              flipper1.showNext();
          }
        }
    };
}