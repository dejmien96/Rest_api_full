package pl.lodz.uni.math.web_service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button click;
   public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = findViewById(R.id.button_click);
        data = findViewById(R.id.text_id);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download_data process = new download_data();
                process.execute();
            }
        });
    }
}
