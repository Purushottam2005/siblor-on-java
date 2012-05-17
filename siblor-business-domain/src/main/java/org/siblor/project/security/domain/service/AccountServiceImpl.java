package org.siblor.project.security.domain.service;

import org.siblor.project.security.domain.model.User;
import org.siblor.project.security.domain.model.UserRepository;

/**
 * Copyright 2012 Putthibong Boonbong
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AccountServiceImpl implements AccountService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(User user) {
        userRepository.insert(user);
    }

    @Override
    public void activate(Integer userId) {
        User user = userRepository.getById(userId);
        user.activate();
        userRepository.update(user);
    }

    @Override
    public void deactivate(Integer userId) {
        User user = userRepository.getById(userId);
        user.deactivate();
        userRepository.update(user);
    }

    @Override
    public void remove(Integer userId) {
        userRepository.delete(userId);
    }
}
