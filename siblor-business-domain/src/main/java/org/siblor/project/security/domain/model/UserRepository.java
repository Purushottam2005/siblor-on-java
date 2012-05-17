package org.siblor.project.security.domain.model;

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
public interface UserRepository {

    void insert(User user);

    void update(User user);

    void delete(Integer id);

    User getById(Integer id);

    User getByUsername(String username);

//    List<User> findUserByGroupName(String name);
//
//    List<User> findUserByRoleName(String name);

}
