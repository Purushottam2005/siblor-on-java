package org.siblor.project.security.domain.service;

import org.apache.commons.lang.Validate;
import org.siblor.project.security.InvalidPasswordException;
import org.siblor.project.security.UserNotFoundException;
import org.siblor.project.security.domain.model.User;
import org.siblor.project.security.domain.model.UserRepository;

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
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void verify(String username, String password) {
        Validate.notEmpty(username, "Username is required!");
        Validate.notEmpty(password, "Password is required!");

        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User '" + username + "' not found!");
        }

        if (!password.equals(user.getPassword())) {
            throw new InvalidPasswordException("User '" + username + "' enter invalid password!");
        }
    }
}
