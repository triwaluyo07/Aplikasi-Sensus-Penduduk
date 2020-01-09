package triwaluyo.aplikasisensuspenduduk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import triwaluyo.aplikasisensuspenduduk.Model.Users;
import triwaluyo.aplikasisensuspenduduk.R;
import triwaluyo.aplikasisensuspenduduk.recyclerView;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {

    public List<Users> usersList;
    private Context con;
    private FirebaseFirestore db;
    private RecyclerView mRecycleList;

    public UsersListAdapter(Context con, List<Users> usersList, FirebaseFirestore db, RecyclerView mRecycleList )
    {
        this.con = con;
        this.usersList = usersList;
        this.db=db;
        this.mRecycleList = mRecycleList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Users users = usersList.get(position);

        holder.txtProvinsi.setText(users.getIdProv());
        holder.txtKota.setText(users.getIdKota());
        holder.txtKecamatan.setText(users.getIdKecamatan());
        holder.txtKelurahan.setText(users.getIdKelurahan());
        holder.txtRW.setText(users.getIdRW());
        holder.txtRT.setText(users.getIdRT());
        holder.txtKepKel.setText(users.getIdJmlKeluarga());
        holder.txtJmlPend.setText(users.getIdJlmPend());
        holder.txtPengisi.setText(users.getEmail());
    }

    @Override
    public int getItemCount() {

        return usersList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        View mView;

        public TextView txtProvinsi;
        public TextView txtKota;
        public TextView txtKecamatan;
        public TextView txtKelurahan;
        public TextView txtRW;
        public TextView txtRT;
        public TextView txtKepKel;
        public TextView txtJmlPend;
        public TextView txtPengisi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;

            txtProvinsi = (TextView) mView.findViewById(R.id.txtProvinsi);
            txtKota = (TextView) mView.findViewById(R.id.txtKota);
            txtKecamatan = (TextView) mView.findViewById(R.id.txtKecamatan);
            txtKelurahan = (TextView) mView.findViewById(R.id.txtKelurahan);
            txtRW = (TextView) mView.findViewById(R.id.txtRW);
            txtRT = (TextView) mView.findViewById(R.id.txtRT);
            txtKepKel = (TextView) mView.findViewById(R.id.txtKepKel);
            txtJmlPend = (TextView) mView.findViewById(R.id.txtJmlPend);
            txtPengisi = (TextView) mView.findViewById(R.id.txtPengisi);

        }
    }

}
