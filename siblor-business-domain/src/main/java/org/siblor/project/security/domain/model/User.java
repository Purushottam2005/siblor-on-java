package org.siblor.project.security.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2012 Putthibong Boonbong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class User {

    private Integer id;

    private String email;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Boolean enable;

//    private List<Group> groups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

//    public List<Group> getGroups() {
//        if (groups == null) {
//            groups = new ArrayList<>();
//        }
//        return groups;
//    }
//
//    protected void setGroups(List<Group> groups) {
//        this.groups = groups;
//    }
//
//    public void addGroup(Group group) {
//        if (!this.getGroups().contains(group)) {
//            this.getGroups().add(group);
//        }
//    }
//
//    public void removeGroup(Group group) {
//        if (this.getGroups().contains(group)) {
//            this.getGroups().remove(group);
//        }
//    }

    public void activate() {
        this.setEnable(true);
    }

    public void deactivate() {
        this.setEnable(false);
    }
}
