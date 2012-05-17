package org.siblor.project.web.security.controller;

import org.siblor.project.security.domain.model.User;
import org.siblor.project.security.domain.model.UserFactory;
import org.siblor.project.security.domain.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
@RequestMapping("/security/user")
public class UserFormController {

    private UserFactory userFactory;
    private UserRepository userRepository;

    public void setUserFactory(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/form")
    public void prepareForm(@RequestParam(required = false) Integer id, Model model) {
        if (id == null) {
            model.addAttribute("user", userFactory.createInstance());
        } else {
            model.addAttribute("user", userRepository.getById(id));
        }
    }

    @RequestMapping("/form/submit")
    public void submitForm(User user) {
        if (user.getId() == null) {
            userRepository.insert(user);
        } else {
            userRepository.update(user);
        }
    }

}
