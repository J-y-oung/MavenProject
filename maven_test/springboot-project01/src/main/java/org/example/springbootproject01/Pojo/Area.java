package org.example.springbootproject01.Pojo;

public class Area {
    private String id;
    private String country_id;
    private String code;
    private String name;
    private String cname;
    private String lower_name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCountry_id() {
        return country_id;
    }
    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getLower_name() {
        return lower_name;
    }
    public void setLower_name(String lower_name) {
        this.lower_name = lower_name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id='" + id + '\'' +
                ", country_id='" + country_id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", lower_name='" + lower_name + '\'' +
                '}';
    }
}
