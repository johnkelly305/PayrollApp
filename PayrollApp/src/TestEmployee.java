import java.io.FileWriter;

public class TestEmployee {

    public String EmployeeName = "";
    public Integer EmployeeSalaryAfterBonus = 0;
    public Integer EmployeeSalaryBeforeBonus = 0;
    public Integer EmployeeBonus = 0;

    public String EmployeePrefix = "";

    public int intResult = 0;



    public Integer CalculateEmployeeSalaryAfterBonus(Integer SalaryBeforeBonus, Integer Bonus)
    {
        intResult = SalaryBeforeBonus + Bonus;
        WriteLine();
        return  intResult;



    }

    public void WriteLine()
    {


        System.out.println("******************** " + EmployeePrefix + " ********************");
        System.out.println("Employee Name : " + EmployeeName);
        System.out.println("Salary Before Bonus : $" + EmployeeSalaryBeforeBonus);
        System.out.println("Salary After Bonus : $" + intResult + "\n");





    }









}
