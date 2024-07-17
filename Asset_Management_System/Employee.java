package Asset_Management_System;

import java.util.*;
public class Employee {
    public int employeeid;
    public String employeename;
    public List<Device>devices;

    public Employee(int employeeid, String employeename) {
            this.employeeid = employeeid;
            this.employeename = employeename;
            this.devices = new ArrayList<Device>();
        }


    public void addDevice(Device device) {
        devices.add(device);
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }
    public List<Device> getDevices() {
        return devices;
    }

        @Override
        public String toString() {
             return "Employee{" +
                    "employeeid=" + employeeid +
                    ", employeename='" + employeename + '\'' +
                    ", devices=" + devices +
                    '}';
        }

    
}
