package br.com.boletim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.boletim.Aluno;

public class AlunoDAO extends Conexao {

	public List<Aluno> listar() {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			String sql = "select * from Aluno "
					+ "order by nome";
			
			PreparedStatement ps = getConexao().
					prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Aluno a;
			while (rs.next()) {
				a = new Aluno();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setMatricula(rs.getString("matricula"));
				a.setNota1(rs.getDouble("nota1"));
				a.setNota2(rs.getDouble("nota2"));
				a.setNota3(rs.getDouble("nota3"));
				
				lista.add(a);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void incluir(Aluno aluno) {
		 try{
		String sql = "insert into aluno (nome, matricula, nota1, nota2, nota3) "
                 + "values (?,?,?,?,?)";
		 PreparedStatement ps = getConexao().prepareStatement(sql);
		 ps.setString(1, aluno.getNome());
         ps.setString(2, aluno.getMatricula());
         ps.setDouble(3, aluno.getNota1());
         ps.setDouble(4, aluno.getNota2());
         ps.setDouble(5, aluno.getNota3());
         
         ps.execute();
         ps.close();
	}catch(SQLException ex) {
        ex.printStackTrace();
    } finally {
        fecharConexao();
    }
	}
	public void excluir(long id) {
        try{
            String sql = "delete from aluno where id = ?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            ps.close(); 
           }catch(SQLException e){
                e.printStackTrace();
          }finally{
                fecharConexao();
          }
	}
	public Aluno buscar(long id) {
        Aluno a = new Aluno ();
        
        try {
            String sql = "SELECT * FROM aluno al"
                         + " where al.id = ?";
            PreparedStatement ps = getConexao()
                    .prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
               a.setId(rs.getInt("id"));
               a.setNome(rs.getString("nome"));
               a.setMatricula(rs.getString("matricula"));
               a.setNota1(rs.getDouble("nota1"));
               a.setNota2(rs.getDouble("nota2"));
               a.setNota3(rs.getDouble("nota3"));
            }
       
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return a;
    }
	 public void alterar(Aluno a) {

	        try {
	            String sql = "update aluno set "
	                    + " nome = ?, "
	                    + " matricula = ?, "
	                    + " nota1 = ?, "
	                    + " nota2 = ?, "
	                    + " nota3 = ? "
	                    + " where id = ?";

	            PreparedStatement ps = getConexao()
	                    .prepareStatement(sql);
	            ps.setString(1, a.getNome());
	            ps.setString(2, a.getMatricula());
	            ps.setDouble(3, a.getNota1());
	            ps.setDouble(4, a.getNota2());
	            ps.setDouble(5, a.getNota3());
	            ps.setLong(6, a.getId());
	            ps.execute();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	 }
}
