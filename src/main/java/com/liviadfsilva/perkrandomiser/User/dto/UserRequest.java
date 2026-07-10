package com.liviadfsilva.perkrandomiser.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String username;
    private String rawPassword;
    private List<Long> perkIds;
}

// TO-DO: switch to record