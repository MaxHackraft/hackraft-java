package net.hackraft.core.model.action;

import java.math.BigInteger;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public class ActionMouseBO {

    private String actionId;
    private String userId;
    private Integer x;
    private Integer y;
    private BigInteger stamp;
    private String target;
    private SpeedBO speedBO;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public BigInteger getStamp() {
        return stamp;
    }

    public void setStamp(BigInteger stamp) {
        this.stamp = stamp;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public SpeedBO getSpeedBO() {
        return speedBO;
    }

    public void setSpeedBO(SpeedBO speedBO) {
        this.speedBO = speedBO;
    }
}
