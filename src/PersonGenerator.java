import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean doneInput = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        String rec = "";
        int YOB = 0;

        ArrayList <String> people = new ArrayList<>();

        do
        {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [******]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Enter your title");
            YOB = SafeInput.getRangedInt(in, "Enter your Year of Birth", 1000, 9999);

            rec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            people.add(rec);

            System.out.println(rec);

            doneInput = SafeInput.getYNConfirm(in, "Are you done ");
        }while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");


        // display the arraylist
        for(String s: people)
            System.out.println(s);

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String p : people)
            {
                writer.write(p, 0, p.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}