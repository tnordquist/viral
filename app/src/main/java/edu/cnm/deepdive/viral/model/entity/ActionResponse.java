package edu.cnm.deepdive.viral.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Action.class,
            parentColumns = "action_id",
            childColumns = "response_to_id"
        ),
        @ForeignKey(
            entity = Action.class,
            parentColumns = "action_id",
            childColumns = "response_id"
        )
    },
    indices = {
        @Index(value = {"response_to_id"}, unique = true),
        @Index(value = {"response_id"})
    }
)
@SuppressWarnings({"NullableProblems", "NotNullFieldNotInitialized"})
public class ActionResponse {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "action_response_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "response_to_id")
  private Long responseTo;

  @ColumnInfo(name = "response_id")
  private long response;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Long getResponseTo() {
    return responseTo;
  }

  public void setResponseTo(@NonNull Long responseTo) {
    this.responseTo = responseTo;
  }

  public long getResponse() {
    return response;
  }

  public void setResponse(long response) {
    this.response = response;
  }

}
