package util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;
    private static boolean firstTimeStart = Boolean.parseBoolean(loadPropeties().getProperty("firstTimeStart", "true"));

    static {
        if (firstTimeStart) {
            firstConfigurationDB();
            Properties props =  loadPropeties();
            props.setProperty("firstTimeStart", "false");
            try (FileOutputStream output = new FileOutputStream("db.properties")) {
                props.store(output, "Configurações de DB");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private static void firstConfigurationDB() {
        Statement st = null;

        try  {
            Connection conn = getConnection();
            String pathCreateCategoria = "src/main/resources/createCategoria.sql";
            String pathCreateProcedure = "src/main/resources/createProcedure.sql";
            String pathCreateProduto = "src/main/resources/createProduto.sql";

            String createCategoriaSql = SqlFileReader.read(pathCreateCategoria).toString();
            String createProdutoSql = SqlFileReader.read(pathCreateProduto).toString();
            String createProcedureSql = SqlFileReader.read(pathCreateProcedure).toString();

            st = conn.createStatement();

            st.execute(createCategoriaSql);
            st.execute(createProdutoSql);
            st.execute(createProcedureSql);

            System.out.println("Configuracao inicial banco de dados criado com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatement(st);
            closeConnection();
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadPropeties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);

            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeStatement(Statement st){
        if (st != null) {
            try{
                st.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try{
                rs.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }


    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadPropeties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e){
            throw new DbException(e.getMessage());
        }
    };

}
