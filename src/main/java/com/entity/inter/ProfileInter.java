package com.entity.inter;

import com.entity.Profile;

import java.util.List;

public interface ProfileInter {
    List<Profile> getAll();

    Profile getProfileById(int id);

    boolean removeProfile(Profile profile);

}
