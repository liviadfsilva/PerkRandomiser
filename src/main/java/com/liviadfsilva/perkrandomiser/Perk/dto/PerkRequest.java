package com.liviadfsilva.perkrandomiser.Perk.dto;

import com.liviadfsilva.perkrandomiser.Perk.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerkRequest {
    private String name;
    private Role role;
    private List<Long> categoryIds;
}

// TO-DO: switch to record
