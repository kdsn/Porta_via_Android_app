package dk.porta_via.porta_via;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordRecoveryActivity extends AppCompatActivity {

    private EditText et_reset_user;
    private Button btn_password_recovery;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);

        firebaseAuth = FirebaseAuth.getInstance();

        Button btn_back_to_login = findViewById(R.id.link_back_to_login);
        btn_back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLogin();
            }
        });

        btn_password_recovery = findViewById(R.id.btn_password_recovery);
    }

    private void openActivityLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
