package com.testing.csv;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class Scanner
{
    public static void main(String[] args)
    {
        CSVReader reader = null;
        try
        {

            reader = new CSVReader(new FileReader("users.csv"));
            String [] nextLine;

            while ((nextLine = reader.readNext()) != null)
            {
                for(String token : nextLine)
                {
                    System.out.print(token);
                }
                System.out.print("\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}  