package Day01_Arraylist;


/**
 * 充电桩离线记录实体类
 * 封装单条充电桩离线日志信息
 */
public class ChargePileOfflineRecord {
    // 充电桩设备唯一编号
    private String pileId;
    // 设备离线时间
    private String offlineTime;
    // 离线原因（断电/故障/信号中断）
    private String offlineReason;
    // 设备恢复在线时间
    private String recoverTime;

    // 无参构造
    public ChargePileOfflineRecord() {}

    // 全参构造
    public ChargePileOfflineRecord(String pileId, String offlineTime, String offlineReason, String recoverTime) {
        this.pileId = pileId;
        this.offlineTime = offlineTime;
        this.offlineReason = offlineReason;
        this.recoverTime = recoverTime;
    }

    // 重写toString，方便打印日志记录
    @Override
    public String toString() {
        return "充电桩离线记录{" +
                "设备编号='" + pileId + '\'' +
                ", 离线时间='" + offlineTime + '\'' +
                ", 离线原因='" + offlineReason + '\'' +
                ", 恢复时间='" + recoverTime + '\'' +
                '}';
    }

    // getter/setter方法
    public String getPileId() { return pileId; }
    public void setPileId(String pileId) { this.pileId = pileId; }
    public String getOfflineTime() { return offlineTime; }
    public void setOfflineTime(String offlineTime) { this.offlineTime = offlineTime; }
    public String getOfflineReason() { return offlineReason; }
    public void setOfflineReason(String offlineReason) { this.offlineReason = offlineReason; }
    public String getRecoverTime() { return recoverTime; }
    public void setRecoverTime(String recoverTime) { this.recoverTime = recoverTime; }
}

