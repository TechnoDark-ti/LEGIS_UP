package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classes.*;        
        
public class CRUD {

    public void createFuncionario(Funcionario funcionario) {
        Connection connection = ConnectBD.getConnection();
        String sql = "INSERT INTO Funcionario (cpf, nome, cargo, departamento_id, salario) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCargo());
            stmt.setInt(4, funcionario.getDepartamento_id());
            stmt.setDouble(5, funcionario.getSalario()); // Reparar isso lá na Classe Funcionario
            stmt.executeUpdate();
            System.out.println("Funcionário inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectBD.closeConnection(connection);
        }
    }

    public Funcionario readFuncionario(long cpf) {
        Connection connection = ConnectBD.getConnection();
        String sql = "SELECT * FROM Funcionario WHERE cpf = ?";
        Funcionario funcionario = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("cargo"),
                    rs.getInt("departamento_id"),
                    rs.getDouble("salario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectBD.closeConnection(connection);
        }
        return funcionario;
    }

    public void updateFuncionario(Funcionario funcionario) {
        Connection connection = ConnectBD.getConnection();
        String sql = "UPDATE Funcionario SET nome = ?, cargo = ?, departamento_id = ?, salario = ? WHERE cpf = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setInt(3, funcionario.getDepartamento_id());
            stmt.setDouble(4, funcionario.getSalario());
            stmt.setString(5, funcionario.getCpf());
            stmt.executeUpdate();
            System.out.println("Funcionário atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectBD.closeConnection(connection);
        }
    }

    public void deleteFuncionario(long cpf) {
        Connection connection = ConnectBD.getConnection();
        String sql = "DELETE FROM Funcionario WHERE cpf = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, cpf);
            stmt.executeUpdate();
            System.out.println("Funcionário deletado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectBD.closeConnection(connection);
        }
    }
    public void createDespesas(){
    
    
    
    }
    /*
    Criar o restante das operações
    - Despesas
    - FolhaPagamento
    - Orcamento
    - Patrimonio
    - Protocolo
    - Receita
    - Sessao
    - Votacao
    - Departamento
    
    */
}