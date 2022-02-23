package main.java4;

/**
 * @author lirenxiang
 * @date 2022/2/23 20:55
 */
public class Girl {

    private String name;

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
