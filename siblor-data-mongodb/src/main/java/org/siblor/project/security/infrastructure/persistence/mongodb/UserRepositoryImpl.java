package org.siblor.project.security.infrastructure.persistence.mongodb;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.siblor.project.security.domain.model.UserRepository;
import org.siblor.project.security.domain.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;

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
public class UserRepositoryImpl implements UserRepository {

    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void update(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void delete(Integer id) {
        mongoTemplate.remove(this.getById(id));
    }

    @Override
    public User getById(Integer id) {
        return mongoTemplate.findById(id, User.class);
    }
    @Override
    public User getByUsername(String username) {
        return mongoTemplate.findOne(query(where("username").is(username)), User.class);
    }
}
