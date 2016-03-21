package gold.reststack.service;

import gold.reststack.models.User;
import gold.reststack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016.3.21.
 */
@Service
public class UserServiceIml {

    @Autowired
    private UserRepository userRepository;

    public void add(User user){
        userRepository.saveAndFlush(user);
    }
}
