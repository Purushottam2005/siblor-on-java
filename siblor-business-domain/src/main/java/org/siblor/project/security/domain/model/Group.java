package org.siblor.project.security.domain.model;

import java.util.ArrayList;
import java.util.List;

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
public class Group {

    private Integer id;

    private String name;

    private String description;

    private List<User> users;

    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    protected void setUsers(List<User> users) {
        this.users = users;
    }

    public Role getRole() {
        if (role == null) {
            role = new Role();
        }
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void addUser(User user) {
        if (!this.getUsers().contains(user)) {
            this.getUsers().add(user);
        }
    }

    public void removeUser(User user) {
        if (this.getUsers().contains(user)) {
            this.getUsers().remove(user);
        }
    }
}
