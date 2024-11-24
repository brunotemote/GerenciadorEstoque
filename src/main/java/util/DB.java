package util;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

            List<String> sqlFiles = new ArrayList<>();

            sqlFiles.add("src/main/resources/createCategoria.sql");
            sqlFiles.add("src/main/resources/createProduto.sql");
            sqlFiles.add("src/main/resources/createAlertaEstoque.sql");
            sqlFiles.add("src/main/resources/createMovimentacao.sql");
            sqlFiles.add("src/main/resources/createRelatorioProdutos.sql");
            sqlFiles.add("src/main/resources/createRelatorioVendas.sql");
            sqlFiles.add("src/main/resources/createProcedure.sql");

            sqlFiles.add("src/main/resources/triggerEstoqueBaixo.sql");
            sqlFiles.add("src/main/resources/triggerMovimentacao.sql");
            sqlFiles.add("src/main/resources/triggerRelatorioProdutoInsert.sql");
            sqlFiles.add("src/main/resources/triggerRelatorioProdutoUpdate.sql");
            sqlFiles.add("src/main/resources/triggerRelatorioVendas.sql");

            st = conn.createStatement();

            for(String file : sqlFiles){
                String sql = SqlFileReader.read(file);
                System.out.println(sql + "\n" + "-------------------------");
                st.execute(sql);
            }

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
