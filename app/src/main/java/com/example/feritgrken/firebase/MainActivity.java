package com.example.feritgrken.firebase;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText etMail,etPassword;
    Button btnGiris;
    ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMail=(EditText)findViewById(R.id.etMail);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(context);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnGiris=(Button)findViewById(R.id.btnGiris);

        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kaydet();
                Intent intent=new Intent(context,StorageActivity.class);
                intent.putExtra("userMail", etMail.getText().toString());
                startActivity(intent);
            }
        });
    }
    private void Kaydet()
    {
        String email=etMail.getText().toString();
        String password=etPassword.getText().toString();
        progressDialog.setMessage("Kaydediliyor");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(context,"Başarılı",Toast.LENGTH_SHORT).show();

                }

            }
        });
        progressDialog.dismiss();
    }
}
