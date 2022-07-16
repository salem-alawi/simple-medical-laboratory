package com.github.salemalawi.medicallaboratory.security;



import com.github.salemalawi.medicallaboratory.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TokenContent  implements Serializable {
    private String userId;
    private String userName;
    private String email;
    private String ethAddress;

    public TokenContent(User user) {

        this.userId=user.getId();
        this.userName=Optional.ofNullable(user.getUserName()).orElse("");

    }
}


