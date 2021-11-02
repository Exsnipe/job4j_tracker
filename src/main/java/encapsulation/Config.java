package encapsulation;

public class Config {
    private String name;
    private int position;
    public String[] properties;

    public Config(String name) {
        this.name = name;
    }

    void print() {
        System.out.println(position);
    }

    public String getProperty(String key) {
        return search(key);
    }

    public String search(String key) {
        return key;
    }
}
