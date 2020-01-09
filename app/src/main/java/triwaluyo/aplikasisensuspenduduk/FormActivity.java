package triwaluyo.aplikasisensuspenduduk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import triwaluyo.aplikasisensuspenduduk.R;

public class FormActivity extends AppCompatActivity {

    private EditText idProv, idKota, idKecamatan, idKelurahan,
            idRW, idRT, idJmlKeluarga, idJlmPend;
    private Button btnSubmit;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        idProv = findViewById(R.id.idProv);
        idKota = findViewById(R.id.idKota);
        idKecamatan = findViewById(R.id.idKecamatan);
        idKelurahan = findViewById(R.id.idKelurahan);
        idRT = findViewById(R.id.idRT);
        idRW = findViewById(R.id.idRW);
        idJmlKeluarga = findViewById(R.id.idJmlKeluarga);
        idJlmPend = findViewById(R.id.idJmlPend);
        btnSubmit = findViewById(R.id.btnSubmit);

    }

    public void fungsiSubmitData(View view) {
        final String prov = idProv.getText().toString();
        final String kota = idKota.getText().toString();
        final String kecam = idKecamatan.getText().toString();
        final String kelur = idKelurahan.getText().toString();
        final String rt = idRT.getText().toString();
        final String rw = idRW.getText().toString();
        final String JmlKel = idJmlKeluarga.getText().toString();
        final String JmlPend = idJlmPend.getText().toString();

        FirebaseUser user = mAuth.getCurrentUser();
        final String email = user.getEmail();

//        String id = db.collection("RiwayatPenduduk").document().getId();
//        DocumentReference reference = db.collection("RiwayatPenduduk").document(id);
//
//        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
//        {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task)
//            {
//                if(task.isSuccessful())
//                {
//                    DocumentSnapshot doc = task.getResult();
//                    if(doc.exists())
//                    {
//                        Toast.makeText(
//                                getApplicationContext(),
//                                "Data is already submitted by " + email,
//                                Toast.LENGTH_SHORT
//                        ).show();
//                    }
//                    else
//                    {
//                        if(prov.matches("")||kota.matches("")||kecam.matches("")||kelur.matches("")||
//                                rt.matches("")||rw.matches("")||JmlKel.matches("")||JmlPend.matches(""))
//                        {
//                            Toast.makeText(FormActivity.this,"Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Map<String,String> riwayat = new HashMap<>();
//                            riwayat.put("Provinsi", prov);
//                            riwayat.put("Kota",kota);
//                            riwayat.put("Kecamatan",kecam);
//                            riwayat.put("Kelurahan",kelur);
//                            riwayat.put("RT",rt);
//                            riwayat.put("RW",rw);
//                            riwayat.put("Jumlah Kepala Keluarga",JmlKel);
//                            riwayat.put("Jumlah Penduduk",JmlPend);
//                            riwayat.put("Pengisi",email);
//
//                            db.collection("RiwayatPenduduk")
//                                    .add(riwayat);
//                            Toast.makeText(getApplicationContext(), "Input Sukses", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                        }
//                    }
//                }
//            }
//        });

        if(prov.matches("")||kota.matches("")||kecam.matches("")||kelur.matches("")||
                rt.matches("")||rw.matches("")||JmlKel.matches("")||JmlPend.matches(""))
        {
            Toast.makeText(FormActivity.this,"Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Map<String,String> riwayat = new HashMap<>();
            riwayat.put("Provinsi", prov);
            riwayat.put("Kota",kota);
            riwayat.put("Kecamatan",kecam);
            riwayat.put("Kelurahan",kelur);
            riwayat.put("RT",rt);
            riwayat.put("RW",rw);
            riwayat.put("Jumlah Kepala Keluarga",JmlKel);
            riwayat.put("Jumlah Penduduk",JmlPend);
            riwayat.put("Pengisi",email);

            db.collection("RiwayatPenduduk")
                    .add(riwayat);
            Toast.makeText(this, "Input Sukses", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,MainActivity.class));
        }



    }


}
