import java.util.Scanner;

public class SafeInputObj
{
    Scanner pipe;

    public SafeInputObj(Scanner pipe)
    {
        this.pipe = pipe;
    }

    public String getNonZeroLenString(String prompt)
    {
        String retVal = "";

        do
        {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if(retVal.isEmpty())
            {
                System.out.println("You must enter at least one character!");
            }
        } while(retVal.isEmpty());

        return retVal;
    }

    public int getInt(String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }

        } while(!done);

        return retVal;
    }


    public double getDouble(String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }

        } while(!done);

        return retVal;
    }


    public int getRangedInt(String prompt, int low, int high)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print(prompt +  " [" + low + " - " + high + "]: ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();

                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a valid integer in range [" + low + " - " + high + "]: ");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }

        } while(!done);

        return retVal;
    }

    public double getRangedDouble(String prompt, double low, double high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print(prompt +  " [" + low + " - " + high + "]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();

                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a valid double in range [" + low + " - " + high + "]: ");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }

        } while(!done);

        return retVal;
    }


    public boolean getYNConfirm(String prompt)
    {
        String input = "";
        boolean retVal = false;
        boolean done = false;

        do
        {
            System.out.println(prompt + "[Yy/Nn]: ");
            input = pipe.nextLine();
            if(input.isEmpty())
            {
                System.out.println("You must enter Y or N!");
            }
            else if(input.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if(input.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("You must enter Y or N! Not: " + input);
            }

        } while(!done);

        return retVal;
    }


    public String getRegExString(String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + regEx + ": ");
            retVal = pipe.nextLine();
            if(retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("You must enter a value that matches pattern " + regEx + "not " + retVal);
            }
        } while(!done);

        return retVal;
    }
}
