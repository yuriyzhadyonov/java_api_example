package api.test.ideals.core.models;

import com.google.gson.Gson;

public class UserPojoBuilder {

    private UserPojo newUserPojo;

    public UserPojoBuilder() {
        newUserPojo = new UserPojo();
    }

    public UserPojoBuilder adCompany(String company) {
        newUserPojo.getAd().setCompany(company);
        return this;
    }

    public UserPojoBuilder adText(String text) {
        newUserPojo.getAd().setText(text);
        return this;
    }

    public UserPojoBuilder dataFirstName(String name) {
        newUserPojo.getData().setFirst_name(name);
        return this;
    }

    public UserPojoBuilder dataLastName(String name) {
        newUserPojo.getData().setLast_name(name);
        return this;
    }

    public UserPojoBuilder dataEmail(String email) {
        newUserPojo.getData().setEmail(email);
        return this;
    }

    public UserPojoBuilder dataId(int id) {
        newUserPojo.getData().setId(id);
        return this;
    }

    public UserPojo build() {
        return newUserPojo;
    }

    public String buildForUpdate() {

        return new Gson().toJson(newUserPojo);

    }

}
