public abstract class ProductList {
    private int ID;
    private String title;
    private int productSize;

    public ProductList(int ID, String title, int productSize){
        this.ID = ID;
        this.title = title;
        this.productSize = productSize;
    }
    public ProductList(){

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public int getProductSize() {
        return productSize;
    }

}
