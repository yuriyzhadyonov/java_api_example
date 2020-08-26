package api.test.ideals.core.models;

import java.util.Date;

public class UserPojo implements IPojo{

    public class UserData {

        private int id;
        private String email;
        private String first_name;
        private String last_name;

        @Override
        public String toString() {
            return "UserData{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }
    }

    public class UserAd{
        private String company;
        private String text;

        @Override
        public String toString() {
            return "UserAd{" +
                    "company='" + company + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    private UserData data = new UserData();
    private UserAd ad = new UserAd();

    private Date createdAt;
    private Date updatedAt;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public UserAd getAd() {
        return ad;
    }

    public void setAd(UserAd ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "data=" + data +
                ", ad=" + ad +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
