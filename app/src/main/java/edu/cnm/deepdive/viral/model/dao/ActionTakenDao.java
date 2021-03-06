package edu.cnm.deepdive.viral.model.dao;

import android.view.animation.AccelerateInterpolator;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.viral.model.entity.ActionTaken;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ActionTakenDao {

  String FEED_ACTIONS_QUERY =
      "SELECT * "
      + "FROM ActionTaken AS at "
      + "INNER JOIN `Action` AS ac ON at.action_id = ac.action_id "
      + "WHERE ac.public = true "
      + "ORDER BY timestamp DESC";

  String FRIEND_POSTS_QUERY =
      "SELECT * "
          + "FROM ActionTaken AS at "
          + "INNER JOIN `Action` AS ac ON at.action_id = ac.action_id "
          + "WHERE ac.public = true AND friend_id = :friend "
          + "ORDER BY timestamp DESC";

  String FRIEND_MESSAGES_QUERY =
      "SELECT * "
      + "FROM ActionTaken AS at "
      + "INNER JOIN `Action` AS ac ON at.action_id = ac.action_id "
      + "WHERE ac.public = false AND friend_id = :friend "
      + "ORDER BY timestamp ASC";

  @Insert
  Single<Long> insert(ActionTaken actionTaken);

  @Insert
  Single<List<Long>> insert(ActionTaken... actionsTaken);

  @Insert
  Single<List<Long>> insert(Collection<ActionTaken> actionsTaken);

  @Update
  Single<Integer> update(ActionTaken actionTaken);

  @Update
  Single<Integer> update(ActionTaken... actionsTaken);

  @Update
  Single<Integer> update(Collection<ActionTaken> actionsTaken);

  @Delete
  Single<Integer> delete(ActionTaken actionTaken);

  @Delete
  Single<Integer> delete(ActionTaken... actionsTaken);

  @Delete
  Single<Integer> delete(Collection<ActionTaken> actionsTaken);

  @Query("SELECT * FROM ActionTaken WHERE action_taken_id = :id")
  LiveData<ActionTaken> selectSpecificActionTaken(long id);

  @Query(FEED_ACTIONS_QUERY)
  LiveData<List<ActionTaken>> selectFeedActions();

  @Query(FRIEND_POSTS_QUERY)
  LiveData<List<ActionTaken>> selectPostsByFriend(long friend);

  @Query(FRIEND_MESSAGES_QUERY)
  LiveData<List<ActionTaken>> selectMessagesByFriend(long friend);

}
