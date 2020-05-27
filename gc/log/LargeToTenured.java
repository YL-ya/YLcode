package gc.log;

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 *
 * @author 38134
 */
public class LargeToTenured {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}