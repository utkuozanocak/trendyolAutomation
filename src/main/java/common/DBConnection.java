/*
package common;

import java.sql.*;

public class DBConnection {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    private String ssEnvironment = "";


    public void connect() throws SQLException,ClassNotFoundException
    {
        String[] _dataSet = new String[2];
        String databaseURL = "jdbc:sqlserver://10.35.160.7;databaseName=TestDB;user=SOLTEST;password=SOL2000!";
        //String user = "root";
        //String password = "root";
        connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL);
            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public void connectPrp() throws SQLException,ClassNotFoundException
    {
        String[] _dataSet = new String[2];
        String databaseURL = "jdbc:sqlserver://10.35.160.5;databaseName=SolTelcoPreProd;user=SOLTEST;password=SOL2000!";
        //String user = "root";
        //String password = "root";
        connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL);
            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public String URL_VALUE;
    public String OBJECT_VALUE;
    private String sEnvironment = "";
    public  String GetUrl(String strapp)
    {
        try
        {
            connect();
            statement = connection.createStatement();
            rs = statement.executeQuery("select Url from TBL_App where App='"+strapp+"' and Environment='"+ssEnvironment+"'");

            while (rs.next()) {

                URL_VALUE = rs.getNString("Url");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return URL_VALUE;
    }
    public String GetObject(String strApp,String strObjectName,String strObjectType,String strPageName)
    {
        try
        {
            connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select ObjectValue from TBL_PageObjects tpo " +
                    "join TBL_ObjectTypes tot on tpo.ObjectTypeID=tot.ObjectTypeID " +
                    "join TBL_Pages tp on tp.PageID=tpo.PageID " +
                    "join TBL_App ta on ta.AppID=tpo.AppID " +
                    "where ta.App='"+strApp+"' and ta.Environment='"+ssEnvironment+"' " +
                    "and tpo.ObjectName='"+strObjectName+"' " +
                    "and tot.ObjectType='"+strObjectType+"' and tp.PageName='"+strPageName+"'");

            while (rs.next())
            {

                OBJECT_VALUE = rs.getNString("ObjectValue");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return OBJECT_VALUE;
    }

    public String GetObject(String strApp,String strObjectName,String strObjectType,String strPageName,String strEnv)
    {
        try
        {
            connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select ObjectValue from TBL_PageObjects tpo " +
                    "join TBL_ObjectTypes tot on tpo.ObjectTypeID=tot.ObjectTypeID " +
                    "join TBL_Pages tp on tp.PageID=tpo.PageID " +
                    "join TBL_App ta on ta.AppID=tpo.AppID " +
                    "where ta.App='"+strApp+"' and ta.Environment='"+strEnv+"' " +
                    "and tpo.ObjectName='"+strObjectName+"' " +
                    "and tot.ObjectType='"+strObjectType+"' and tp.PageName='"+strPageName+"'");

            while (rs.next())
            {

                OBJECT_VALUE = rs.getNString("ObjectValue");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return OBJECT_VALUE;
    }
    public  String[] GetTestParameter(String strTestName,String strParameterName)
    {
        String[] dataSet  = new String[4];
        try
        {
            connect();
            statement = connection.createStatement();

            rs = statement.executeQuery("select tp.TestParameterValue from TBL_TestParamMove tpa " +
                    "join TBL_TestParameters tp on tpa.TestParameterID=tp.TestParameterID " +
                    "join TBL_Tests t on t.TestID=tpa.TestID where t.TestName = '"+strTestName+"' and tp.TestParameterName = '"+strParameterName+"'");
            int i=0;
            while (rs.next())
            {
                dataSet[i] = rs.getNString("TestParameterValue");
                i = i + 1;
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return dataSet;
    }
    public String[] GetLocationData(String LocationType)
    {
        String[] dataSet = new String[1];
        try
        {
            connectPrp();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT top 1 pqlu.LocationId FROM PQuiknetAddress pqa " +
                    "JOIN PQuiknetLocationUnit pqlu (nolock) on pqa.LocationID = pqlu.LocationId " +
                    "JOIN TAddress ta (nolock) on pqlu.ID = ta.PLocationUnitId " +
                    "JOIN PSiteLocation psl (nolock) on pqa.LocationID=psl.LocationId where " +
                    "pqa.LocationInfrastructure = '"+LocationType+"' AND " +
                    "pqa.StatusDescription = 'AKTIF (Satisa Hazir)' AND " +
                    "pqa.IntegratorCode IS NOT NULL AND pqa.GcRecordId is null and " +
                    "psl.GcRecordId is null and pqlu.ProductInstanceBaseId is null and " +
                    "ta.PLocationUnitId IS NOT NULL AND pqa.EmptorSiteId IS NOT NULL ORDER BY NEWID()");
            while (rs.next())
            {
                dataSet[0] = rs.getNString("LocationId");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return dataSet;
    }
    public String[] GetLocationDaireData(String LocationType,String LocationId)
    {
        String[] dataSet = new String[1];
        try
        {
            connectPrp();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT top 1 pqlu.LocationUnitName FROM PQuiknetAddress pqa " +
                    "JOIN PQuiknetLocationUnit pqlu (nolock) on pqa.LocationID = pqlu.LocationId " +
                    "JOIN TAddress ta (nolock) on pqlu.ID = ta.PLocationUnitId " +
                    "JOIN PSiteLocation psl (nolock) on pqa.LocationID=psl.LocationId where " +
                    "pqa.LocationInfrastructure = '"+LocationType+"' AND " +
                    "pqa.StatusDescription = 'AKTIF (Satisa Hazir)' AND " +
                    "pqa.IntegratorCode IS NOT NULL AND pqa.GcRecordId is null and " +
                    "psl.GcRecordId is null and pqlu.ProductInstanceBaseId is null and " +
                    "ta.PLocationUnitId IS NOT NULL AND pqa.EmptorSiteId IS NOT NULL " +
                    "and pqlu.LocationId = '"+LocationId+"' ORDER BY NEWID()");
            while (rs.next()) {
                dataSet[0] = rs.getNString("LocationUnitName");
            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }
    public String[] FoxSearchFlowNo(String CustomerNo, String TaskId, String FlowStatus)
    {
        String[] dataSet = new String[1];
        try
        {
            connectFoxPrp();
            statement = connection.createStatement();

            rs= statement.executeQuery("DECLARE @MUSTERINO NVARCHAR(20) = '"+CustomerNo+"'" +
                    "    SELECT DISTINCT top 1 w.ID" +
                    "    FROM   NFWDTT_WORKFLOWINSTANCE(NOLOCK) w"+
                    "    INNER JOIN dbo.NFWDFT_WORKFLOWVERSION v(NOLOCK)"+
                    "    ON  v.ID = w.WORKFLOWVERSION"+
                    "    INNER JOIN NFWDTT_WORKFLOWSEARCHKEY(NOLOCK) s"+
                    "    ON  s.WORKFLOWINSTANCE = w.ID"+
                    "    AND s.SEARCHKEY = 'MUSTERINOKEY'"+
                    "    AND s.[VALUE] = @MUSTERINO"+
                    "    LEFT JOIN NFWDTT_WORKFLOWSEARCHKEY(NOLOCK) s2"+
                    "    ON  s2.WORKFLOWINSTANCE = w.ID"+
                    "    AND s2.SEARCHKEY = 'TASKIDCODE'"+
                    "    WHERE s2.[VALUE]='"+TaskId+"'"+
                    "   AND w.WORKFLOWSTATUS = '"+FlowStatus+"'"+
                    "    ORDER BY  w.ID DESC");

            while (rs.next())
            {
                dataSet[0] = rs.getString("ID");

            }
            connection.close();
            System.out.println("Connection Closed to the Database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }
    public void connectFoxPrp() throws SQLException,ClassNotFoundException
    {
        String[] _dataSet = new String[2];
        String databaseURL = "jdbc:sqlserver://172.20.164.143:52282;databaseName=NetflowGlobal;user=nf_user;password=mahfel16";
        connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL);
            if (connection != null)
            {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
}
*/
