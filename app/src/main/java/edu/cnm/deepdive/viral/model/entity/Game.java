package edu.cnm.deepdive.viral.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(indices = @Index(value = {"start_time", "end_time"}, unique = true))
public class Game { // Read that all primitives are NonNull by default?

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  // Do the dates need to be unique keys? I imagine they will be unique simply because one cannot
  // possibly start two new games in the same second.
  @NonNull
  private Date startTime;

  @NonNull
  private Date endTime;

  private int moves;

  private int friendsLeft;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public int getMoves() {
    return moves;
  }

  public void setMoves(int moves) {
    this.moves = moves;
  }

  public int getFriendsLeft() {
    return friendsLeft;
  }

  public void setFriendsLeft(int friendsLeft) {
    this.friendsLeft = friendsLeft;
  }

}