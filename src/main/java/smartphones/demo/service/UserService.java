package smartphones.demo.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.User;
import smartphones.demo.repository.UserRepository;
import pl.coderslab.model.Err;


@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findUser(String name){ return userRepository.findFirstByName(name); }
    public void registerUser(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        User userToCheck = userRepository.getOne((long) 1);
        if( userToCheck == null) user.setAdmin(true);
        userRepository.save(user);
    }

    public void checkNameAndPassword(User user, Err modelErr){
        User userToCheck = userRepository.findFirstByName(user.getName());

        if(userToCheck== null){
            modelErr.addErr("Wrong email!");
        }else{
            if (!(BCrypt.checkpw(user.getPassword(), userToCheck.getPassword()) )) {
                modelErr.addErr("Wrong password!");
            }
        }
    }

    public void checkPwd (User user, Err modelErr) {

        if (!user.getPassword().equals(user.getRepeatedPassword())) {
            modelErr.addErr("Hasła muszą być takie same!");
        }
    }

    public void checkIfNameIsUnique(User user, Err modelErr){

        User checkUser = userRepository.findFirstByName(user.getName());
        if (checkUser != null) {
            modelErr.addErr("Taki użytkownik już istnieje !");
        }
    }



}
