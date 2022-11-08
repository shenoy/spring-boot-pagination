package dev.shenoy.jpapaging.model;

public class PersonsRequest {
   public int page;
   public int size;

    @Override
    public String toString() {
        return "PersonsRequest{" +
                "page=" + page +
                ", size=" + size +
                '}';
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
