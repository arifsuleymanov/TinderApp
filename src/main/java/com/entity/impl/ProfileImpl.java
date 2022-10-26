package com.entity.impl;

import com.entity.Profile;
import com.entity.inter.AbstractDao;
import com.entity.inter.ProfileInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileImpl extends AbstractDao implements ProfileInter {
    @Override
    public List<Profile> getAll() {
        List<Profile> profiles = new ArrayList<>();
        Connection conn;
        try {
            conn = get();
            Statement stmt = conn.createStatement();
                stmt.execute("SELECT * FROM tinderapp.profiles");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String profile_link = rs.getString("profile_link");
                String workspace = rs.getString("workspace");
                Date last_login_date = rs.getDate("last_login_date");
                profiles.add(new Profile(id,name,surname,profile_link,workspace,last_login_date));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return profiles;

    }

    @Override
    public Profile getProfileById(int id) {
        return new ProfileImpl().getAll().get(id);
    }

    @Override
    public boolean removeProfile(Profile profile) {
        try {
            Connection c = get();
            PreparedStatement statement = c.prepareStatement("delete from " +
                    "tinderapp.profiles where profile_link=?");
            statement.setString(1,profile.getProfile_link());
            return statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
