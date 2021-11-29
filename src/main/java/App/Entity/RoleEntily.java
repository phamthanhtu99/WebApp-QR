package App.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntily extends Base{
   @Enumerated(EnumType.STRING)
    @Column
    private ERole eRole;

   @ManyToMany(mappedBy = "roleEntily")
    List<UserEntity>userEntities = new ArrayList<>();
    public ERole geteRole() {
        return eRole;
    }
    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }
}
