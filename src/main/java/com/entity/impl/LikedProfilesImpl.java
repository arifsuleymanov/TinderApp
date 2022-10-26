package com.entity.impl;

import com.entity.Profile;
import com.entity.User;
import com.entity.inter.AbstractDao;
import com.entity.inter.LikedProfilesInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class LikedProfilesImpl extends AbstractDao implements LikedProfilesInter {

    private User currentUser = new User(-1,"test","test");

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public List<Profile> getAll() {
        List<Profile> profiles = new ArrayList<>();
        Connection conn;
        try {
            conn = get();
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM tinderapp.liked_profiles");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                if (userID== User.getId()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String profile_link = rs.getString("profile_link");
                    String workspace = rs.getString("workspace");
                    Date last_login_date = rs.getDate("last_login_date");
                    profiles.add(new Profile(id, name, surname, profile_link, workspace, last_login_date));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return profiles;

    }

    @Override
    public Profile getProfileById(Long id) {
        return null;
    }

    @Override
    public boolean addProfile(Profile profile) {
        try {
            System.out.println("in try");
            Connection c = get();
            PreparedStatement statement = c.prepareStatement("insert into " +
                    "tinderapp.liked_profiles(name, surname, profile_link,workspace,last_login_date,userID) values (?,?,?,?,?,?)");
            statement.setString(1, profile.getName());
            statement.setString(2, profile.getSurname());
            statement.setString(3, profile.getProfile_link());
            statement.setString(4, profile.getWorkspace());
            statement.setDate(5, profile.getLast_login_date());
            statement.setInt(6, User.getId());
            return statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
