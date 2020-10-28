package edu.cnm.deepdive.viral.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(foreignKeys = {
    @ForeignKey(
        entity = Action.class,
        parentColumns = "action_id",
        childColumns = "action_id"
    ),
    @ForeignKey(
        entity = ActionResponse.class,
        parentColumns = "response_to_id",
        childColumns = "response_to_id"
    ),
    @ForeignKey(
        entity = Friend.class,
        parentColumns = "friend_id",
        childColumns = "friend_id"
    )
})
public class ActionTaken {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "action_taken_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "friend_id")
  private Friend friend;

  @NonNull
  private Date timestamp;

  @NonNull
  @ColumnInfo(name = "action_id")
  private Action action;

  @NonNull
  @ColumnInfo(name = "response_to_id")
  private ActionResponse responseTo;

  @NonNull
  private String content; // Do I even need this if it can just reference the content of the action?

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Friend getFriend() {
    return friend;
  }

  public void setFriend(Friend friend) {
    this.friend = friend;
  }

  @NonNull
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NonNull Date timestamp) {
    this.timestamp = timestamp;
  }

  @NonNull
  public Action getAction() {
    return action;
  }

  public void setAction(@NonNull Action action) {
    this.action = action;
  }

  @NonNull
  public ActionResponse getResponseTo() {
    return responseTo;
  }

  public void setResponseTo(@NonNull ActionResponse responseTo) {
    this.responseTo = responseTo;
  }

  @NonNull
  public String getContent() {
    return content;
  }

  public void setContent(@NonNull String content) {
    this.content = content;
  }

}
