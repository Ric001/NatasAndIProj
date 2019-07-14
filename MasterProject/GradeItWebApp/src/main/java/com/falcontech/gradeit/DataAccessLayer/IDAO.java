package com.falcontech.gradeit.DataAccessLayer;

import java.util.List;

import com.falcontech.gradeit.models.University;

public interface IDAO {
    public List<University> listUniversities();
    public boolean closeResources();
    public boolean closeConnection();
    public boolean closeCallableStatement();
    public boolean closeResultSet();
}