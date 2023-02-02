import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;
public class Employee {

    public int fgList;
    String EmployeeGpName = "";
    String EmployeeGpPrefix = "";



    public Integer GetEmployeeCount()
    {
        return  Integer.parseInt(AppConfigSettings("Employee_Count"));
    }

    public Employee(String EmployeeGroupName)
    {
        EmployeeGpName = EmployeeGroupName;
        EmployeeGpPrefix = AppConfigSettings(EmployeeGpName);
    }


    public String EmployeeGroupName()
    {
        return EmployeeGpName;
    }

    public String EmployeeGroupPrefix()
    {
        return EmployeeGpPrefix;
    }



    public String GetEmployeeName()
    {
        return AppConfigSettings(EmployeeGpPrefix + "_Name");

    }

    public Integer GetEmployeeSalaryBeforeBonus()
    {
        return Integer.parseInt(AppConfigSettings(EmployeeGpPrefix + "_SalaryBeforeBonus"));
    }

    public Integer GetEmployeeBonus()
    {
        return Integer.parseInt(AppConfigSettings(EmployeeGpPrefix + "_BonusAmount"));

    }

    public Integer GetEmployeeSalaryAfterBonus()
    {
        return Integer.parseInt(AppConfigSettings(EmployeeGpPrefix + "_SalaryAfterBonus"));
    }


    public Integer ProcessEmployeePayroll()
    {

        TestEmployee thisEmployee = new TestEmployee();
        thisEmployee.EmployeeName = GetEmployeeName();
        thisEmployee.EmployeeSalaryBeforeBonus = GetEmployeeSalaryBeforeBonus();
        thisEmployee.EmployeeBonus = GetEmployeeBonus();
        thisEmployee.EmployeePrefix = EmployeeGroupPrefix();
        return   thisEmployee.EmployeeSalaryAfterBonus = thisEmployee.CalculateEmployeeSalaryAfterBonus(thisEmployee.EmployeeSalaryBeforeBonus , this.GetEmployeeBonus());

    }







    public  String AppConfigSettings(String AppConfigItem)
    {
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
