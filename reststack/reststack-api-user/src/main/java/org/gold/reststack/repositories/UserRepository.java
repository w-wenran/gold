package org.gold.reststack.repositories;


import org.gold.reststack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016.3.21.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
