package com.epm.manage.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Project")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String projectName;
    private String clientName;
    private String sarname;
    private String email;
    private Integer cost;
    private Integer serverExpance;
    private String frontend;
    private String backend;
    private String mobile;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "projects")
    private Set<Emp> emps = new HashSet<>();
    public Project(){}
    public Project(String projectName, String clientName, String sarname, String email, Integer cost, Integer serverExpance, String frontend, String backend, String mobile, Set<Emp> emps) {
        this.projectName = projectName;
        this.clientName = clientName;
        this.sarname = sarname;
        this.email = email;
        this.cost = cost;
        this.serverExpance = serverExpance;
        this.frontend = frontend;
        this.backend = backend;
        this.mobile = mobile;
        this.emps = emps;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSarname() {
        return sarname;
    }

    public void setSarname(String sarname) {
        this.sarname = sarname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getServerExpance() {
        return serverExpance;
    }

    public void setServerExpance(Integer serverExpance) {
        this.serverExpance = serverExpance;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

    public Project(Long id, String projectName, String clientName, String sarname, String email, Integer cost, Integer serverExpance, String frontend, String backend, String mobile, Set<Emp> emps) {
        Id = id;
        this.projectName = projectName;
        this.clientName = clientName;
        this.sarname = sarname;
        this.email = email;
        this.cost = cost;
        this.serverExpance = serverExpance;
        this.frontend = frontend;
        this.backend = backend;
        this.mobile = mobile;
        this.emps = emps;
    }
}
