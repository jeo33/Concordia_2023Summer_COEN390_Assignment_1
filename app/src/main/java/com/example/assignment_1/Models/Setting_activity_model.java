package com.example.assignment_1.Models;

public class Setting_activity_model {


    private String[] labels=new String[4];
    private String order;



    private int count;

    private int size=0;

    private String TotalCount;
    public Setting_activity_model()
    {
        labels[0]="Event A";
        labels[1]="Event B";
        labels[2]="Event C";
        labels[3]="Total Count";
        size=0;
        count=0;
        order=null;
        TotalCount="Total Count ";
    }

    public String getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(String totalCount) {
        TotalCount = totalCount;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void SetLabels(int index,String content)
    {
        labels[index]=content;

    }

    public void setSize(int size)
    {
        this.size= size;
    }

    public int getSize()
    {
        return size;
    }
    public String GetLabels(int index)
    {
       return this.labels[index];
    }

    public String GetOrder()
    {
        return this.order;
    }
    public String SetOrder(String content)
    {
        return this.order=content;
    }

    public void append(String a)
    {
        order=order+a;
    }
}
