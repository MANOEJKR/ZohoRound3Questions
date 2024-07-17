package Asset_Management_System;

import java.util.*;
public class Device {

        public int deviceid;
        public List<Installation> installations;
        public  Employee employee;

        public Device(int deviceid, Employee employee) {
            this.deviceid = deviceid;
            this.installations = new ArrayList<Installation>();
            this.employee = employee;
        }

        public void setInstallation(Installation installation) {
            installations.add(installation);
        }

        public int getdeviceid()
        {
            return deviceid;
        }

        

         
}
