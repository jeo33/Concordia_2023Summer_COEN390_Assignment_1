package com.example.assignment_1.Models;

import com.example.assignment_1.Views.DataActivity;

public class Data_activity_model {


    private String log;
    private String[] ListViewDisplay_name ;

    private String[] ListViewDisplay_number ;
    private int Count;
    private  String[] itemList;

    int Item1Count=0;
    int Item2Count=0;
    int Item3Count=0;


    public Data_activity_model(int count, String log,String x,String y,String z){
        this.Count=count;
        this.log=log;
        this.itemList=new String[3];
        this.itemList[0]=x;
        this.itemList[1]=y;
        this.itemList[2]=z;
        this.ListViewDisplay_number=getListViewDisplay_number();
        this.ListViewDisplay_name=getListViewDisplay_name();

    }


    public String[] getListViewDisplay_number() {

        char[] charArray = getLog().toCharArray();
        String[] ListViewDisplay = new String[charArray.length];
        for (int i=0;i<charArray.length;i++)
        {

            if (charArray[i]=='1')
            {
                ListViewDisplay[i]=itemList[0];
            }
            else if (charArray[i]=='2') {
                ListViewDisplay[i]=itemList[1];

            }
            else if (charArray[i]=='3') {
                ListViewDisplay[i]=itemList[2];
            }

        }
        return ListViewDisplay;
    }

    public int getcount(int x)
    {
        if(x==1)
        {
            return Item1Count;
        } else if (x==2) {
            return Item2Count;

        }
        else if(x==3) {
            return Item3Count;

        }

        return 0;
    }


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setListViewDisplay_number(String[] listViewDisplay_number) {
        ListViewDisplay_number = listViewDisplay_number;
    }

    public String[] printListViewDisplay_name()
    {
        return this.ListViewDisplay_name;
    }

    public String[] printListViewDisplay_number()
    {
        return this.ListViewDisplay_number;
    }
    public String[] getListViewDisplay_name() {


        char[] charArray = getLog().toCharArray();
        String[] ListViewDisplay = new String[charArray.length];
        for (int i=0;i<charArray.length;i++)
        {

            if (charArray[i]=='1')
            {
                ListViewDisplay[i]="1";
                Item1Count++;
            }
            else if (charArray[i]=='2') {
                ListViewDisplay[i]="2";
                Item2Count++;
            }
            else if (charArray[i]=='3') {
                ListViewDisplay[i]="3";
                Item3Count++;
            }

        }
        return ListViewDisplay;
    }

    public void setListViewDisplay_name(String[] listViewDisplay_name) {
        ListViewDisplay_name = listViewDisplay_name;
    }


    public String GetLabels(int index)
    {
        return this.itemList[index];
    }

    public void SetLabels(int index,String content)
    {
        itemList[index]=content;

    }




    public void setCount(int Count)
    {
        this.Count= Count;
    }

    public int getCount()
    {
        return Count;
    }




}
