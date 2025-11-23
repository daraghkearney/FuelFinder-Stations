package ie.atu.cicdproject.ffmainapp.Controller;

import ie.atu.cicdproject.ffmainapp.Service.UserService;
import ie.atu.cicdproject.ffmainapp.Model.UserInformation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private final UserService uService;

    public UserController(UserService uService)
    {
        this.uService = uService;
    }

    @GetMapping // Gets all Users Information
    public ResponseEntity<List<UserInformation>> findAll()
    {
        return ResponseEntity.ok(uService.findAll());
    }

    @GetMapping("/{id}") // Gets one user by their ID
    public ResponseEntity<UserInformation> getOne(@PathVariable String id)
    {
        Optional<UserInformation> maybe = uService.findById(id);
        if(maybe.isPresent())
        {
            return ResponseEntity.ok(maybe.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping // Updated Method for create user
    public ResponseEntity<UserInformation> create(@Valid @RequestBody UserInformation user)
    {
        UserInformation created = uService.create(user);
        return ResponseEntity
                .created(URI.create("/api/users" + created.getUserID()))
                .body(created);
    }

    @PutMapping("/{id}") // New method for updating user data
    public ResponseEntity<UserInformation> update(@PathVariable String id, @Valid @RequestBody UserInformation updated)
    {
        Optional<UserInformation> maybe = uService.update(id, updated);
        return maybe.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        boolean removed = uService.deleteById(id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
