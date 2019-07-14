package com.falcontech.gradeit.DataAccessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import com.falcontech.gradeit.models.Career;
import com.falcontech.gradeit.models.Pensum;
import com.falcontech.gradeit.models.Subject;
import com.falcontech.gradeit.models.University;

public class MySQLDAO implements IDAO {

    private CallableStatement stpCaller;
    private ResultSet resultSet;
    private ISinggleConnector connectorManager;

    private static final String storedProcedure = "";
    private static final Logger LOG = Logger.getLogger(MySQLDAO.class.getName());

    public MySQLDAO() {
        setConnectorManager(MySQLConnector.connector());
    }

    @Override
    public List<University> listUniversities() {
        LOG.info("[ENTER listUniversities(): List<University>]");
        
        final List<University> universities = new ArrayList<>();
        try {
            stpCaller = connectorManager.connect().prepareCall(storedProcedure);
            if (callProcedure() && Objects.nonNull(resultSet))
                mapResultSet(universities);
            closeResources();
        } catch (SQLException e) {
            LOG.info(e.getMessage());
        }
        
        LOG.info("[RETURNING FROM listUniversites(): List<University>]");
        return Collections.unmodifiableList(universities);
    }
    private void mapResultSet(List<University> colleges) throws SQLException {
        LOG.info("[ENTERING mapResultSet(List<Unviersity> unviersity): boolean]");
        
        University university = null;
        Career career = null;
        Pensum pensum = null;
        List<Subject> subjects = null;

        while(resultSet.next()) {
            university = new University();
            colleges.add(university);
        }

        LOG.info("[ENDING mapResultSet(List<University> unviersity): boolean]");
    }
    @Override
    public boolean closeResources() {
        LOG.info("[ENTER closeResources(): boolean]");
        if (closeResultSet() && closeCallableStatement() && closeConnection())
            return true;
        return false;
    }

    @Override
    public boolean closeConnection() {
        LOG.info("[ENTER closeConnection(): boolean]");
        try {
            final Connection connection = MySQLConnector.connector().connect();
            if (!connection.isClosed())
                connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean closeResultSet() {
        LOG.info("[ENTER closeResultSet(): boolean]");
        try {
            if (!resultSet.isClosed())
                resultSet.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean closeCallableStatement() {
        LOG.info("[ENTER closeCallableStatement(): boolean]");
        
        try {
            if (!stpCaller.isClosed())
                stpCaller.close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }

        LOG.info("[RETURNING closeCallableStatement(): boolean]");
        return false;
    }
    private boolean callProcedure() {
        LOG.info("[ENTER callProcedure(): boolean]");

        if (Objects.nonNull(stpCaller))
            try {
                resultSet = stpCaller.executeQuery();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        LOG.info("[RETURNING callProcedure(): boolean]");
        return false;
    }

    public CallableStatement getStpCaller() {
        return stpCaller;
    }

    public void setStpCaller(CallableStatement stpCaller) {
        this.stpCaller = stpCaller;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ISinggleConnector getConnectorManager() {
        return connectorManager;
    }

    public void setConnectorManager(ISinggleConnector connectorManager) {
        this.connectorManager = connectorManager;
    }
}