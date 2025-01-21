import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWritter
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean doneInput = false;

        String ID = "";
        String name = "";
        String description = "";
        double cost = 0;

        String rec = "";


        ArrayList <String> people = new ArrayList<>();

        do
        {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [******]");
            name = SafeInput.getNonZeroLenString(in, "Enter your first name");
            description = SafeInput.getNonZeroLenString(in, "Enter your last name");
            cost = SafeInput.getDouble(in, "Enter the cost");

            rec = ID + ", " + name + ", " + description + ", " + cost;
            people.add(rec);

            System.out.println(rec);

            doneInput = SafeInput.getYNConfirm(in, "Are you done ");
        }while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String p : people)
            {
                writer.write(p, 0, p.length());  // stupid syntax for write rec
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
