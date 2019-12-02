package com.example.claremountconnection;

public class Users {

    private int id;
    private String title;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String password;
    private String phone;
    private String jobTitle;
    private String employer;
    private String organization;
    private String state;
    private String zip;
    private String major;
    private String minor;
    private String areaOfStudy;
    private String researchInterests;
    private String skills;


    public Users() {}

    public Users (String title, String firstName, String middleName, String lastName,
                 String email, String password, String phone, String jobTitle, String employer,
                 String organization, String state, String zip, String major,  String minor,
                 String areaOfStudy, String researchInterests, String skills) {
 //       this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.employer = employer;
        this.organization = organization;
        this.state = state;
        this.zip = zip;
        this.major = major;
        this.minor = minor;
        this.areaOfStudy = areaOfStudy;
        this.researchInterests = researchInterests;
        this.skills = skills;
    }

    public int getID() {return id; }

    public void setID() {this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getAreaOfStudy() {
        return areaOfStudy;
    }

    public void setAreaOfStudy(String areaOfStudy) {
        this.areaOfStudy = areaOfStudy;
    }

    public String getResearchInterests() {
        return researchInterests;
    }

    public void setResearchInterests(String researchInterests) {
        this.researchInterests = researchInterests;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
