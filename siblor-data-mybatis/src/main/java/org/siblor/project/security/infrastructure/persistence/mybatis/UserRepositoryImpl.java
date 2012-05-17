package org.siblor.project.security.infrastructure.persistence.mybatis;

import org.apache.ibatis.session.SqlSession;
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
public class UserRepositoryImpl implements UserRepository {

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insert(User user) {
        sqlSession.insert("UserRepository.insertUser", user);
    }

    @Override
    public void update(User user) {
        sqlSession.update("UserRepository.updateUser", user);
    }

    @Override
    public void delete(Integer id) {
        sqlSession.delete("UserRepository.deleteById", id);
    }

    @Override
    public User getById(Integer id) {
        return sqlSession.selectOne("UserRepository.getById", id);
    }

    @Override
    public User getByUsername(String username) {
        return sqlSession.selectOne("UserRepository.getByUsername", username);
    }
}
