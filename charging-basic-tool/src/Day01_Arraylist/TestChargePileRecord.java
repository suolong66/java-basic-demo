package Day01_Arraylist;


/**
 * 测试自定义简易ArrayList存储充电桩离线记录
 * 验证扩容、批量存储、数组拷贝功能
 */
public class TestChargePileRecord {
    public static void main(String[] args) {
        // 1. 初始化自定义容器，默认容量10
        SimpleArrayList<ChargePileOfflineRecord> recordList = new SimpleArrayList<>();

        // 打印初始状态：默认容量、初始记录数
        System.out.println("【初始化状态】");
        System.out.println("初始数组容量：" + recordList.getCapacity());
        System.out.println("初始记录条数：" + recordList.size());

        // 2. 构建12条离线记录（超过默认容量10，触发扩容阈值，自动扩容）
        ChargePileOfflineRecord[] batchRecords = new ChargePileOfflineRecord[12];
        batchRecords[0] = new ChargePileOfflineRecord("P001", "2026-07-01 10:20", "断电", "2026-07-01 10:30");
        batchRecords[1] = new ChargePileOfflineRecord("P002", "2026-07-02 09:15", "信号中断", "2026-07-02 09:18");
        batchRecords[2] = new ChargePileOfflineRecord("P003", "2026-07-03 14:40", "设备故障", "2026-07-03 15:00");
        batchRecords[3] = new ChargePileOfflineRecord("P004", "2026-07-04 08:20", "断电", "2026-07-04 08:25");
        batchRecords[4] = new ChargePileOfflineRecord("P005", "2026-07-05 16:30", "信号中断", "2026-07-05 16:32");
        batchRecords[5] = new ChargePileOfflineRecord("P006", "2026-07-06 11:10", "设备故障", "2026-07-06 11:25");
        batchRecords[6] = new ChargePileOfflineRecord("P007", "2026-07-07 13:50", "断电", "2026-07-07 13:55");
        batchRecords[7] = new ChargePileOfflineRecord("P008", "2026-07-08 17:20", "信号中断", "2026-07-08 17:22");
        batchRecords[8] = new ChargePileOfflineRecord("P009", "2026-07-09 07:40", "设备故障", "2026-07-09 08:00");
        batchRecords[9] = new ChargePileOfflineRecord("P010", "2026-07-10 12:10", "断电", "2026-07-10 12:15");
        // 第11条数据，触发扩容阈值（10/10），执行1.5倍扩容（容量变为15）
        batchRecords[10] = new ChargePileOfflineRecord("P011", "2026-07-11 09:30", "信号中断", "2026-07-11 09:33");
        batchRecords[11] = new ChargePileOfflineRecord("P012", "2026-07-12 15:20", "设备故障", "2026-07-12 15:40");

        // 3. 批量添加离线记录
        recordList.addBatch(batchRecords);

        // 4. 打印扩容后状态
        System.out.println("\n【批量存储后状态】");
        System.out.println("扩容后数组容量：" + recordList.getCapacity());
        System.out.println("实际存储记录条数：" + recordList.size());

        // 5. 遍历打印所有离线记录
        System.out.println("\n【所有充电桩离线记录】");
        recordList.printAllRecord();
    }
}

