import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class Program {

    public static void main(String[] args)
    {
        RetrieveConfigurationSettings ConfigSettings = new RetrieveConfigurationSettings();

        try
        {
            System.out.println("ABC Payroll");
            for (Employee myEmployee: ConfigSettings.GetEmployeeList()
            ) {

                int ProcessEmployeeCalculation = myEmployee.ProcessEmployeePayroll();


            }
        }
        catch (Exception ex)
        {

        }


    }


    private static String AppConfigSettings(String AppConfigItem){

        try
        {

            Path FindPathOfThePropertiesFile = Paths.get("src");
            Path PropertiesFileAbsolutePath = FindPathOfThePropertiesFile.toAbsolutePath();
            Path myPath = PropertiesFileAbsolutePath.resolve("Config.properties");
            FileReader myReader = new FileReader(myPath.toString());
            Properties Prop = new Properties();
            Prop.load(myReader);
            AppConfigItem =  Prop.getProperty(AppConfigItem);

        }
        catch (Exception ex)
        {

        }


        return AppConfigItem;


    }








}
