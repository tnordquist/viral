package edu.cnm.deepdive.viral.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@SuppressWarnings({"NullableProblems", "NotNullFieldNotInitialized"})
@Entity(
    foreignKeys = @ForeignKey(
        entity = Demeanor.class,
        parentColumns = "demeanor_id",
        childColumns = "demeanor_id"
        // what sort of onDeletes are required if dependent entities are deleted together?
    ),
    indices = {
        @Index(value = {"name"}, unique = true),
//        @Index(value = {"address"}),
        @Index(value = {"profile_picture"}),
        @Index(value = {"demeanor_id"})
    }
)
public class Friend {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "friend_id")
  private long id;

  @NonNull
  private String name;

  @ColumnInfo(name = "infection_level")
  private int infectionLevel;

  @ColumnInfo(name = "demeanor_id")
  private long demeanor;

  private boolean active;

  private int address;

  @NonNull
  @ColumnInfo(name = "profile_picture")
  private String profilePicture;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getInfectionLevel() {
    return infectionLevel;
  }

  public void setInfectionLevel(int infectionLevel) {
    this.infectionLevel = infectionLevel;
  }

  public long getDemeanor() {
    return demeanor;
  }

  public void setDemeanor(long demeanor) {
    this.demeanor = demeanor;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public int getAddress() {
    return address;
  }

  public void setAddress(int address) {
    this.address = address;
  }

  public String getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }

  @NonNull
  @Override
  public String toString() {
    return name;
  }

}
