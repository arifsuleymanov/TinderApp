package com;

import com.entity.Profile;
import com.entity.impl.ProfileImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProfileImpl profile = new ProfileImpl();
        List<Profile> profiles = profile.getAll();
        System.out.println("You are in main " + profiles.size());
        System.out.println(profiles.get(0).getProfile_link());
        System.out.println(profiles.get(3).dateDiff().getDays());
    }

}
