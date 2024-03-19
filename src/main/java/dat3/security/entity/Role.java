package dat3.security.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
   @Id
   private String roleName;

   public Role(String roleName) {
      this.roleName = roleName;
   }


   // Lars: This is not needed, as we are using the mappedBy attribute in UserWithRoles
   // IN FACT, this will cause a StackOverflowError, as the two entities will keep calling each other
   // THANKS LARS!!!!
//   @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
//   Set<UserWithRoles> users;
//
//   public void addUser(UserWithRoles user) {
//      if(users == null) users = new HashSet<>();
//      users.add(user);
//   }
}
