package com.entity.inter;

import com.entity.Profile;

import java.util.List;

public interface LikedProfilesInter {
    List<Profile> getAll();
    Profile getProfileById(Long id);
    boolean addProfile(Profile profile);

}
