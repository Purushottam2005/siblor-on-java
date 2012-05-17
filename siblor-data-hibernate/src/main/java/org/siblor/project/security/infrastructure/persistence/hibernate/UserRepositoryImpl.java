package org.siblor.project.security.infrastructure.persistence.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.siblor.project.security.domain.model.User;
import org.siblor.project.security.domain.model.UserRepository;

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
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(user);

        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(this.getById(id));

        session.getTransaction().commit();
    }

    @Override
    public User getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(User.class);
        criteria.createCriteria("username", username);

        return (User) criteria.uniqueResult();
    }

}
