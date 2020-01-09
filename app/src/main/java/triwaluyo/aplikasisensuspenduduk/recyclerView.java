package triwaluyo.aplikasisensuspenduduk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import triwaluyo.aplikasisensuspenduduk.Adapter.UsersListAdapter;
import triwaluyo.aplikasisensuspenduduk.Model.Users;

public class recyclerView extends AppCompatActivity {

    private RecyclerView mRecycleList;
    private UsersListAdapter usersListAdapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private List<Users> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecycleList = findViewById(R.id.recycleList);
        mRecycleList.setHasFixedSize(true);
        mRecycleList.setLayoutManager(new LinearLayoutManager(this));

        usersList = new ArrayList<>();

        mRecycleList.setAdapter(usersListAdapter);

        showRecycler();


    }

    public void showRecycler() {
        db.collection("RiwayatPenduduk").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if (task.isSuccessful())
                        {
                            List<Users> dataList = new ArrayList<>();


                            for(QueryDocumentSnapshot document: task.getResult())
                            {
                                Users list = new Users();
                                list.setIdProv(document.get("Provinsi").toString());
                                list.setIdKota(document.get("Kota").toString());
                                list.setIdKecamatan(document.get("Kecamatan").toString());
                                list.setIdKelurahan(document.get("Kelurahan").toString());
                                list.setIdRW(document.get("RW").toString());
                                list.setIdRT(document.get("RT").toString());
                                list.setIdJmlKeluarga(document.get("Jumlah Kepala Keluarga").toString());
                                list.setIdJlmPend(document.get("Jumlah Penduduk").toString());
                                list.setEmail(document.get("Pengisi").toString());
                                dataList.add(list);

                            }
                            usersListAdapter = new UsersListAdapter(getApplicationContext(), dataList, db, mRecycleList);
                            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
                            mRecycleList.setLayoutManager(manager);
                            mRecycleList.setAdapter(usersListAdapter);
                        }
                    }
                });

    }
}
