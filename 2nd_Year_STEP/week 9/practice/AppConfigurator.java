class AppConfig {
    private String appName;

    public AppConfig(String appName) {
        this.appName = appName;
    }

    public static class NetworkConfig {
        private String host;
        private int port;
        private static String defaultProtocol = "HTTP";

        public NetworkConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public void displayConfig() {
            System.out.println("Host: " + host + ", Port: " + port + ", Protocol: " + defaultProtocol);
        }}}

public class AppConfigurator {
    public static void main(String[] args) {
        AppConfig.NetworkConfig netConfig = new AppConfig.NetworkConfig("192.168.0.1", 8080);
        netConfig.displayConfig();

        System.out.println("Default Protocol: " + AppConfig.NetworkConfig.defaultProtocol);
    }}