public abstract class Human {
    private String name;
    private int age;
    private int ID;

    public Human(String name,int age,int ID){
        this.name = name;
        this.age = age;
        this.ID = ID;
    }
    public Human(){

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
