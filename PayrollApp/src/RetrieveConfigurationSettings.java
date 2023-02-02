import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RetrieveConfigurationSettings {

    public List<Employee> employeeList;

    public Integer intEmployeeCount() {


        return Integer.parseInt(AppConfigSettings("Employee_Count"));
    }

    public List<Employee> GetEmployeeList()
    {
        if(employeeList == null)
        {
            if(this.intEmployeeCount() > 0)
            {
                employeeList = new ArrayList<>();
                for (int i = 0; i < this.intEmployeeCount(); i++)
                {
                    String strEmployeeGroupName = "Employee_Label_" + i;
                    Employee EmployeeGroupName = new Employee(strEmployeeGroupName);
                    employeeList.add(EmployeeGroupName);

                }
            }
        }
        return employeeList;
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
