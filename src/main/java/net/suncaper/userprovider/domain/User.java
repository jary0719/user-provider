package net.suncaper.userprovider.domain;

public class User extends UserExt {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.id
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.dept_id
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private Integer deptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.username
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.password
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.nick_name
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.mobile
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.email
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.disabled
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private Boolean disabled;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.secretary
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private Boolean secretary;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.contact
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private Boolean contact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_user.leader
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    private Boolean leader;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.id
     *
     * @return the value of pt_user.id
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.id
     *
     * @param id the value for pt_user.id
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.dept_id
     *
     * @return the value of pt_user.dept_id
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.dept_id
     *
     * @param deptId the value for pt_user.dept_id
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.username
     *
     * @return the value of pt_user.username
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.username
     *
     * @param username the value for pt_user.username
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.password
     *
     * @return the value of pt_user.password
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.password
     *
     * @param password the value for pt_user.password
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.nick_name
     *
     * @return the value of pt_user.nick_name
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.nick_name
     *
     * @param nickName the value for pt_user.nick_name
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.mobile
     *
     * @return the value of pt_user.mobile
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.mobile
     *
     * @param mobile the value for pt_user.mobile
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.email
     *
     * @return the value of pt_user.email
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.email
     *
     * @param email the value for pt_user.email
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.disabled
     *
     * @return the value of pt_user.disabled
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.disabled
     *
     * @param disabled the value for pt_user.disabled
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.secretary
     *
     * @return the value of pt_user.secretary
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public Boolean getSecretary() {
        return secretary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.secretary
     *
     * @param secretary the value for pt_user.secretary
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setSecretary(Boolean secretary) {
        this.secretary = secretary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.contact
     *
     * @return the value of pt_user.contact
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public Boolean getContact() {
        return contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.contact
     *
     * @param contact the value for pt_user.contact
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setContact(Boolean contact) {
        this.contact = contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_user.leader
     *
     * @return the value of pt_user.leader
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public Boolean getLeader() {
        return leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_user.leader
     *
     * @param leader the value for pt_user.leader
     *
     * @mbg.generated Mon Dec 23 14:46:51 CST 2019
     */
    public void setLeader(Boolean leader) {
        this.leader = leader;
    }
}