package com.falcontech.gradeit.DataAccessLayer;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISinggleConnector {
    public Connection connect() throws SQLException;
    
}