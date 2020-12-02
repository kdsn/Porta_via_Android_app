package dk.porta_via.porta_via;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordRecoveryActivity extends AppCompatActivity {

    private EditText et_password_recovery_username;
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

        et_password_recovery_username = findViewById(R.id.et_password_recovery_username);
        btn_password_recovery = findViewById(R.id.btn_password_recovery);
        btn_password_recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = et_password_recovery_username.getText().toString().trim();

                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.sendPasswordResetEmail(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(PasswordRecoveryActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PasswordRecoveryActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }
                        }
                    });
            }
        });
    }

    private void openActivityLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
