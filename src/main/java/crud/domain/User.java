package crud.domain;

public class User {
    private int id;
    private String name;
    private String Sex;
    private int identy;
    private String title;
    private String password;

    public User() {
    }

    public User(int id, String name, String sex, int identy, String title, String password) {
        this.id = id;
        this.name = name;
        Sex = sex;
        this.identy = identy;
        this.title = title;
        this.password = password;
    }

    public User(int identy, String password) {
        this.identy = identy;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getIdenty() {
        return identy;
    }

    public void setIdenty(int identy) {
        this.identy = identy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", identy=" + identy +
                ", title='" + title + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
