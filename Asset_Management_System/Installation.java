package Asset_Management_System;

public class Installation {

        public Software software;
        public String installationdate;

        public Installation(Software software, String installationdate) {
            this.software = software;
            this.installationdate = installationdate;
        }

        public Software getSoftware() {
            return software;
        }

        public String getInstallationdate() {
            return installationdate;
        }
}
