

import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO{

    @Override
    public Connection connect(String urlConexao) {

        Connection conexao = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection(urlConexao);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }

    @Override
    public void createTable(String urlConexao) {

        Connection conn = connect(urlConexao);
        Statement statement = null;
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS cliente (");
        sql.append("id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sql.append("nome varchar(255) NOT NULL, ");
        sql.append("idade INTEGER NOT NULL, ");
        sql.append("cpf varchar(14) NOT NULL, ");
        sql.append("rg varchar(14) NOT NULL");
        sql.append(");");

        try {
            statement = conn.createStatement();
            statement.execute(sql.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (statement != null)
                    statement.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        Connection conexao = connect(url_conexao);
        Statement stm = null;
        try{
             stm = conexao.createStatement();
            String query = "INSERT INTO cliente VALUES (null, '" +  cliente.getNome() + "', " + cliente.getIdade() + " " +
                    " , '" + cliente.getCpf() + "', '" + cliente.getRg() +"');";
            stm.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexao != null)
                    conexao.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        Connection conexao = connect(urlConexao);
        Statement stm = null;
        try{
            stm = conexao.createStatement();
            String query = "SELECT * FROM cliente;";

            ResultSet resultSet = stm.executeQuery(query);

            while(resultSet.next()){
                System.out.println("ID = " + resultSet.getInt("id") +
                        ", NOME = " + resultSet.getString("nome") +
                        ", IDADE = " + resultSet.getInt("idade") +
                        ", CPF = " + resultSet.getString("cpf") +
                        ", RG = " + resultSet.getString("rg")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexao != null)
                    conexao.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        Connection conexao = connect(urlConexao);
        PreparedStatement stm = null;
        try{
            stm = conexao.prepareStatement("UPDATE cliente SET nome = ?, " + "idade = ? " + "WHERE id = ?;");
            stm.setString(1, name);
            stm.setInt(2, idade);
            stm.setInt(3, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexao != null)
                    conexao.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        Connection conexao = connect(urlConexao);
        PreparedStatement stm = null;
        try{
            stm = conexao.prepareStatement("DELETE FROM cliente WHERE id = ?;");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexao != null)
                    conexao.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
