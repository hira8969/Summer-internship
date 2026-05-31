package com.lms.Service;

import com.lms.Dao.MemberDao;

public class MemberService {

    MemberDao dao = new MemberDao();

    public void addMember() {
        dao.addMember();
    }

    public void viewMembers() {
        dao.viewMembers();
    }
}