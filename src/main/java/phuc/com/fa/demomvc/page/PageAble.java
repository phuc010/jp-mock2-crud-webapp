package phuc.com.fa.demomvc.page;

/* class PageAble determine the number of records of a page */
public class PageAble {

    private int page;
    private int size = 5;
    
    //constructor
    public PageAble(int page) {
        super();
        this.page = page;
    }

    //getter and setter
    public int getOffset() {
        return (page - 1) * size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
