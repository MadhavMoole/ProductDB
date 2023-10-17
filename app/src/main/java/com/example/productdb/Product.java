package com.example.productdb;

public class Product {
    int pid;

    public Product(int pid, String pname, String pdesc, double price, int pcat) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.price = price;
        this.pcat = pcat;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    String pname;
    String pdesc;
    double price;
    int pcat;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPcat() {
        return pcat;
    }

    public void setPcat(int pcat) {
        this.pcat = pcat;
    }

    @Override
    public String toString() {
        return   pid +
                ", " + pname + '\'' +
                ", " + pdesc + '\'' +
                ", " + price +
                ", " + pcat;
    }
}
