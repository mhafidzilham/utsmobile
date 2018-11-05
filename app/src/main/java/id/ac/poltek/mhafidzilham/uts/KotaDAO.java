package id.ac.poltek.mhafidzilham.uts;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface KotaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertKota(Kota kota);

    @Query("SELECT * FROM tbkota")
    Kota[] selectAllKota();
}
