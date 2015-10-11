package net.hackraft.core.model.user;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public class UserBO {

    private String userId;
    private Integer gender;
    private String sex;
    private LocationBO location;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocationBO getLocation() {
        return location;
    }

    public void setLocation(LocationBO location) {
        this.location = location;
    }
}
