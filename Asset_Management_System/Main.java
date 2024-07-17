package Asset_Management_System;
 
import java.util.*;
public class Main {
    
   public List<Employee> employees = new ArrayList<Employee>();
    public List<Device> devicesMain = new ArrayList<Device>();
    public List<Vendor> vendors = new ArrayList<Vendor>();
    public List<Software> softwares = new ArrayList<Software>();
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        boolean exit = false;

        while(!exit) {
            System.out.println(" 1 - Register Employee \n 2 - Register vendor \n 3 - Register device \n 4 - Register Software  \n 5 - Installation for a device \n 6 - Report \n 7 - Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    main.RegisterEmployee();
                    break;

                case 2:
                    main.RegisterVendor();
                    break;

                case 3:
                    main.RegisterDevice();
                    break;
            
                case 4:
                    main.RegisterSoftware();
                    break;

                case 5:
                    main.Installationfordevice();
                    break;

                case 6:
                    main.report( );
                    break;

                case 7:
                    exit=true;
                    sc.close();
                    break;

                case 8:
                    main.displayemployee();
                    
                default:
                    break;
            }

    }
     
}
    private void displayemployee() {
         for(Employee emp : employees)
        {
            System.out.println(emp);
        }
    }
    private void Installationfordevice() {
          
        System.out.println("Enter the deviceid");
        int deviceid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the software name");
        String sname = sc.nextLine();
        System.out.println("Enter the installtion date");
        String date = sc.nextLine();

        for(Device device :devicesMain)
        {
            if(device.getdeviceid() == deviceid)
            {
                for(Software soft : softwares )
                {
                    if(soft.getSoftwarename().equals(sname))
                    {
                        Installation in = new Installation(soft,date);
                        device.setInstallation(in);
                        Vendor vendor = soft.softwarevendor;
                        for(Vendor v: vendors)
                        {
                            if(v.equals(vendor))
                            {
                                v.totalcostearned = v.totalcostearned +(int) soft.costforsoftware+v.costforinstall;
                                System.out.println("Vendor billed paid");
                            }
                        }
                        System.out.println("Installation done");
                    }
                }
            }
        }
         


    }
    private void report( ) {
        
       boolean exit =false;
       while(!exit)
       {
            System.out.println(" 1 - Number of installation for particular software \n 2 -Number of software installed in device \n 3 -Numer of software installed for employee \n 4 - Amound spend for software \n 5 -Amound spend for employee \n 6 -Amound spend on vendor \n 7 - Number of installation of software from a vendor \n 8 -Device that as expire date \n 9 -Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                noInstallforsoftware();
                break;

                case 2:
                nosoftwareinstallindevice();
                break;

                case 3:
                nosoftwareinstallforemployee();
                break;

                default:
                System.out.println("Invalid choice");
                break;
            }
       }
        
    }

    public  void nosoftwareinstallforemployee()
    {
       
        System.out.println("Enter the employeeid");
        int employeeid = sc.nextInt();
        sc.nextLine();
        int count=0;
        
        for(Employee employee :employees)
        {
            if(employee.getEmployeeid()==employeeid)
            {
                for(Device device :employee.getDevices())
                {
                    count+=device.installations.size();
                }
            }
        }

        System.out.println("Number of software installed for employee is " + count);
         
    }

    private void nosoftwareinstallindevice()
    {
      
        System.out.println("Enter the deviceid");
        int deviceid = sc.nextInt();
        sc.nextLine();
        int count=0;
        for(Device device :devicesMain)
        {
            if(device.getdeviceid() == deviceid)
            {
                count+= device.installations.size();
            }
        }
        System.out.println("Number of software installed in a devices are : " + count);
       
    }

    private void noInstallforsoftware() {
         
        System.out.println("Enter the software name");
        String sname = sc.nextLine();
        int count=0;
         
        for(Device device :devicesMain)
        {
            for(Installation installation : device.installations)
            {
                if(installation.getSoftware().getSoftwarename().equals(sname))
                {
                    count++;
                    System.out.println("Number of software installed are: " + count);
                    return;
                }
            }
        }
         System.out.println("No software installed");
        
    }
    private void RegisterSoftware() {
        
        System.out.println("Enter the vendorid");
        int vendorid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the software name");
        String sname = sc.nextLine();
        System.out.println("Enter the price of the software");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the expiredate");
        String expiredate = sc.nextLine();
        

        for(Vendor vendor : vendors)
        {
            if(vendor.getvendorid() == vendorid)
            {
                Software software = new Software(sname,expiredate,price,vendor);
                softwares.add(software);
                System.out.println("Software Registered");
                return;
            }
        }
        System.out.println("Vendor not found");
        

    }
    private void RegisterDevice() {
       
        System.out.println("Enter the id of the device");
        int id = sc.nextInt();
        System.out.println("Enter the id of the employee");
        int idemployee =sc.nextInt();
        sc.nextLine();
        
        for(Employee employee :employees) {
            if(employee.getEmployeeid() == idemployee)
            {
                Device device = new Device(id,employee);
                devicesMain.add(device);
                employee.addDevice(device);
                System.out.println("Device Registered");
                return;
            }
        }
        System.out.println("Employee not found");
         

    }
    private void RegisterVendor() {
        
        System.out.println("Enter the name of the vendor");
        String name = sc.nextLine();
        System.out.println("Enter the id for the vendor");
        int id = sc.nextInt();
        sc.nextLine();
        Vendor vendor = new Vendor(name,id);
        vendors.add(vendor);
        

    }
    private  void RegisterEmployee() {
         
         System.out.println("Enter Employee Name");
         String name = sc.nextLine();
         System.out.println("Enter Employee Id");
         int id = sc.nextInt();
         sc.nextLine();
         
         
         Employee employee = new Employee(id,name);
        for(Employee e : employees)
        {
            if(e.getEmployeeid() == id)
            {
                System.out.println("Already registered");
                return;
            }

        }
        employees.add(employee);
         System.out.println("Employee Registered");
         
    }
}
