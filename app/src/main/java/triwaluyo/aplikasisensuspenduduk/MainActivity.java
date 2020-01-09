package triwaluyo.aplikasisensuspenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private Button btnLogout,btnLihat, btnInput;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        btnInput = findViewById(R.id.btnInput);
        btnLihat = findViewById(R.id.btnLihatData);
        btnLogout = findViewById(R.id.btnLogout);

        btnInput.setOnClickListener(this);
        btnLihat.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        {
            startActivity(new Intent(this, triwaluyo.aplikasisensuspenduduk.LoginActivity.class));
        }


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInput:
            {
                startActivity(new Intent(this, triwaluyo.aplikasisensuspenduduk.FormActivity.class));
                break;
            }

            case R.id.btnLihatData:
            {
                startActivity(new Intent(this, triwaluyo.aplikasisensuspenduduk.recyclerView.class));
                break;
            }
            case  R.id.btnLogout :
            {
                mAuth.signOut();
                startActivity(new Intent(this, triwaluyo.aplikasisensuspenduduk.LoginActivity.class));
            }


        }
    }
}
