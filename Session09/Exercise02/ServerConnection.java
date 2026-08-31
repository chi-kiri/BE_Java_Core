package Exercise02;

public class ServerConnection {
    public static final int MAX_CONNECTIONS = 3;

    private static int activeConnections = 0;
    private String connectionId;
    private boolean isConnected = false;

    public ServerConnection(String connectionId) {
        this.connectionId = connectionId;

        if (activeConnections < MAX_CONNECTIONS) {
            isConnected = true;
            activeConnections++;

            System.out.printf(
                    "| [%s] Mở thành công! (Active: %d/%d)%n",
                    connectionId,
                    activeConnections,
                    MAX_CONNECTIONS
            );
        } else {
            isConnected = false;

            System.out.printf(
                    "| [%s] TỪ CHỐI KẾT NỐI! Đã đạt giới hạn tối đa %d/%d%n",
                    connectionId,
                    activeConnections,
                    MAX_CONNECTIONS
            );
        }
    }

    public void closeConnection() {
        if (isConnected) {
            activeConnections--;
            isConnected = false;

            System.out.printf(
                    "| [%s] Đã đóng kết nối! (Active: %d/%d)%n",
                    connectionId,
                    activeConnections,
                    MAX_CONNECTIONS
            );
        }
    }

    public static int getActiveConnections() {
        return activeConnections;
    }
}
