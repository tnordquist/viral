package edu.cnm.deepdive.viral.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.viral.model.entity.Action;
import edu.cnm.deepdive.viral.model.pojo.DemeanorWithActions;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ActionDao {

  String SELECT_ACTION_BY_VISIBILITY_QUERY =
      "SELECT * "
          + "FROM `Action` "
          + "WHERE public = :isPublic AND demeanor_id = :demeanor";

  @Insert
  Single<Long> insert(Action action);

  @Insert
  Single<List<Long>> insert(Action... actions);

  @Insert
  Single<List<Long>> insert(Collection<Action> actions);

  @Update
  Single<Integer> update(Action action);

  @Update
  Single<Integer> update(Action... actions);

  @Update
  Single<Integer> update(Collection<Action> actions);

  @Delete
  Single<Integer> delete(Action... actions);

  @Delete
  Single<Integer> delete(Collection<Action> actions);

  @Query("SELECT * FROM `Action` WHERE action_id = :id")
  LiveData<Action> selectSpecificAction(long id);

  @Query(SELECT_ACTION_BY_VISIBILITY_QUERY)
  LiveData<List<Action>> selectActionsByVisibility(boolean isPublic, long demeanor);

  @Query(SELECT_ACTION_BY_VISIBILITY_QUERY)
  Single<List<Action>> selectActionsByVisibilitySync(boolean isPublic, long demeanor);

  @Transaction
  @Query("SELECT * FROM `Demeanor` WHERE demeanor_id = :id")
  LiveData<DemeanorWithActions> selectAllDemeanorActions(long id);

}
