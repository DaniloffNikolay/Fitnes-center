package main.dataBase;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String middleName;
    private String birthday;
    private String iin;
    private String subscription;
    private String note;

    public User(int id, String name, String lastName, String middleName, String birthday, String iin, String subscription, String note) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.iin = iin;
        this.subscription = subscription;
        this.note = note;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getIin() {
        return iin;
    }
    public String getSubscription() {
        return subscription;
    }
    public String getNote() {
        return note;
    }
}
