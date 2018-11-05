package id.ac.poltek.mhafidzilham.uts.adapter;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.ac.poltek.mhafidzilham.uts.AppDatabase;
import id.ac.poltek.mhafidzilham.uts.Kota;

public class AdapterKotaRecyclerView extends RecyclerView.Adapter<AdapterKotaRecyclerView.ViewHolder> {
    private ArrayList<Kota> daftarKota;
    private Context context;
    private AppDatabase db;

    public AdapterKotaRecyclerView(ArrayList<Kota> kotas, Context ctx) {
        daftarKota = kotas;
        context = ctx;

        db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "kotadb").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ViewHolder vh = new ViewHolder(v);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKotaRecyclerView.ViewHolder viewHolder, int i) {
        final String name = daftarKota.get(i).getNamaKota();
        //viewHolder.txtKota.setText(name);
    }

    @Override
    public int getItemCount() {
        return daftarKota.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
