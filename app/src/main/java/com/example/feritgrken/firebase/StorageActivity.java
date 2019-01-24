package com.example.feritgrken.firebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StorageActivity extends AppCompatActivity {

    TextView tvMail;
    EditText etYas,etKilo,etOkul;
    Button btnDatabaseEkle;
    Context context=this;
    Button btnStorageGit;
    DatabaseReference databaseReference;

    @Override
    protected void   onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        databaseReference=FirebaseDatabase.getInstance().getReference("Ozellikler");
        tvMail = findViewById(R.id.tvMail);
        etYas=findViewById(R.id.etYas);
        etKilo=findViewById(R.id.etKilo);
        etOkul=findViewById(R.id.etOkul);
        btnDatabaseEkle=findViewById(R.id.btnDatabaseEkle);
        btnStorageGit=findViewById(R.id.btnStorageGit);

        String a = getIntent().getExtras().getString("userMail");
        tvMail.setText(a.toString());

        btnDatabaseEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OzellikEkle();
            }
        });

        btnStorageGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,StorActivity.class);
                startActivity(intent);




                

            }
        });
    }
    private void OzellikEkle()
    {
        Integer kilo= Integer.valueOf(etKilo.getText().toString());
        Integer yas=Integer.valueOf(etYas.getText().toString());
        String okul=etOkul.getText().toString();

        String id= databaseReference.push().getKey();
        Ozellikler ozellikler=new Ozellikler(id,kilo,yas,okul);
        databaseReference.child(id).setValue(ozellikler);
    }
}
