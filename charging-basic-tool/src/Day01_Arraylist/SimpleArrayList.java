package Day01_Arraylist;


/**
 * 手写简易ArrayList
 * 功能：批量存储充电桩离线记录，手动实现扩容、数组拷贝
 * 核心知识点：默认容量、扩容阈值、动态数组原理
 * @param <T> 泛型，支持存储任意类型，此处用于存储ChargePileOfflineRecord
 */
public class SimpleArrayList<T> {
    // 1. 定义默认容量：无参构造初始化时，底层数组的初始长度（JDK默认10，此处保持一致）
    private static final int DEFAULT_CAPACITY = 10;

    // 2. 底层存储数据的数组：核心容器，所有充电桩离线记录都存在此数组中
    private Object[] elementData;

    // 3. 数组实际元素个数（当前存储的离线记录数量，区别于数组容量）
    private int size;

    /**
     * 无参构造方法：初始化容器，使用默认容量
     */
    public SimpleArrayList() {
        // 初始化底层数组，容量为默认容量10，可存储10条离线记录
        elementData = new Object[DEFAULT_CAPACITY];
        // 初始元素个数为0，暂无离线记录
        size = 0;
    }

    /**
     * 有参构造方法：自定义初始容量
     * @param initCapacity 自定义初始容量
     */
    public SimpleArrayList(int initCapacity) {
        // 合法性校验：初始容量不能小于0
        if (initCapacity < 0) {
            throw new IllegalArgumentException("初始容量非法：" + initCapacity);
        }
        // 根据自定义容量初始化底层数组
        elementData = new Object[initCapacity];
        // 初始元素个数为0
        size = 0;
    }

    /**
     * 核心方法：添加单条充电桩离线记录
     * @param t 离线记录对象
     */
    public void add(T t) {
        // 扩容判断：当实际元素个数 == 数组容量（达到扩容阈值），触发扩容
        if (size == elementData.length) {
            // 调用手动扩容方法
            grow();
        }
        // 将新的离线记录存入数组末尾
        elementData[size] = t;
        // 实际元素个数+1
        size++;
    }

    /**
     * 核心方法：手动数组扩容（无工具类，纯手动实现）
     * 扩容规则：原容量1.5倍扩容（和JDK ArrayList扩容规则一致）
     */
    private void grow() {
        // 1. 获取原数组的容量
        int oldCapacity = elementData.length;
        // 2. 计算新容量：原容量 + 原容量/2 = 1.5倍扩容
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        // 3. 创建新的大容量数组
        Object[] newElementData = new Object[newCapacity];

        // 4. 手动数组拷贝：循环遍历旧数组，将所有离线记录迁移到新数组
        // 纯手动实现，不调用System.arraycopy等工具方法
        for (int i = 0; i < oldCapacity; i++) {
            newElementData[i] = elementData[i];
        }

        // 5. 底层数组指向新数组，完成扩容替换
        elementData = newElementData;
    }

    /**
     * 批量添加离线记录（适配需求：批量存储场景）
     * @param records 离线记录数组
     */
    public void addBatch(T[] records) {
        // 遍历批量记录，逐个添加
        for (T record : records) {
            add(record);
        }
    }

    /**
     * 根据下标获取指定离线记录
     * @param index 下标
     * @return 对应离线记录
     */
    public T get(int index) {
        // 下标合法性校验
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }
        // 返回对应下标数据，强制泛型转换
        return (T) elementData[index];
    }

    /**
     * 获取当前实际存储的记录条数
     * @return 元素个数size
     */
    public int size() {
        return size;
    }

    /**
     * 获取当前底层数组的容量
     * @return 数组容量
     */
    public int getCapacity() {
        return elementData.length;
    }

    /**
     * 遍历打印所有充电桩离线记录
     */
    public void printAllRecord() {
        for (int i = 0; i < size; i++) {
            System.out.println(elementData[i]);
        }
    }
}

