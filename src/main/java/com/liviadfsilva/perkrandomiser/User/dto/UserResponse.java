package com.liviadfsilva.perkrandomiser.User.dto;

import com.liviadfsilva.perkrandomiser.Perk.model.Perk;
import com.liviadfsilva.perkrandomiser.User.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String username;
    private List<Long> perkIds;

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getUsername(),
                user.getPerks().stream()
                        .map(Perk::getId)
                        .toList()
        );
    }
}
