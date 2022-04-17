package com.testing.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class split
{
    public static void main(String[] args)
    {
        String sample = ",";
        String mystring;
        try
        {
            BufferedReader brdrd = new BufferedReader(new FileReader("user.csv"));
            while ((mystring = brdrd.readLine()) != null)
            {
                String[] student = mystring.split(sample);
                System.out.println("Name: " + student[0] + ",Faculty: " + student[1] + ", Registration No: " + student[2] + ", Fees Balance: " + student[3] + ", Campus:  " + student[4] +"");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}