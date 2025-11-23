package ie.atu.cicdproject.ffmainapp.Service;


import ie.atu.cicdproject.ffmainapp.Model.UserInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final List<UserInformation> store = new ArrayList<>();

    public List<UserInformation> findAll()
    {
        return new ArrayList<>(store);
    }

    public Optional<UserInformation> findById(String id)
    {
        for(UserInformation user : store)
        {
            if(user.getUserID().equals(id))
            {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public UserInformation create(UserInformation user)
    {
        if(findById(user.getUserID()).isPresent())
        {
            throw new IllegalArgumentException("User with id " + user.getUserID() + " already exists");
        }
        store.add(user);
        return user;
    }

    public Optional <UserInformation> update(String id, UserInformation updated)
    {
        for (UserInformation user : store)
        {
            if (user.getUserID().equals(id))
            {
                user.setUserName(updated.getUserName());
                user.setPassword(updated.getPassword());
                user.setEmail(updated.getEmail());
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean deleteById(String id)
    {
        return store.removeIf(user -> user.getUserID().equals(id));
    }
}
