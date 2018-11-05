package id.ac.poltek.mhafidzilham.uts;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

import id.ac.poltek.mhafidzilham.uts.adapter.KotaAdapter;

public class ReadActivity extends AppCompatActivity {
    private AppDatabase db;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Kota> daftarKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        daftarKota = new ArrayList<>();

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "kotadb").allowMainThreadQueries().build();

        rvView = findViewById(R.id.rv_main);
        rvView .setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        daftarKota.addAll(Arrays.asList(db.kotaDAO().selectAllKota()));
        adapter = new KotaAdapter(daftarKota, this);
        rvView.setAdapter(adapter);

        Button btnKembali = findViewById(R.id.buttonKembali);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReadActivity.this, DBActivity.class);
                startActivity(i);
            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, ReadActivity.class);
    }
}
