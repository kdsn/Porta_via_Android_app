package dk.porta_via.porta_via;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ReprintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reprint);

        ImageView iv_dashboard = (ImageView) findViewById(R.id.iv_reprint_to_dashboard);
        iv_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReprintActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}