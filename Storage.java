import java.util.ArrayList;
import java.util.Scanner;

public abstract class Storage {
    private int ID;
    private String address;
    private int responsiblePersonID;
    private int storageSize;
    protected Storage(int ID, String address, int responsiblePersonID, int storageSize){
       this.ID = ID;
       this.address = address;
       this.responsiblePersonID = responsiblePersonID;
       this.storageSize = storageSize;
    }
    public Storage(){

    }


    public void setID(int ID){
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setStorageSize(int storageSize){
        this.storageSize = storageSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setResponsiblePersonID(int responsiblePersonID) {
        this.responsiblePersonID = responsiblePersonID;
    }

    public int getResponsiblePersonID() {
        return responsiblePersonID;
    }



}
