package br.com.livraria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.Autor;

public class AutorDAO extends Conexao{

	public List<Autor> listar() {
		List<Autor> lista = new ArrayList<Autor>();
		try {
			String sql = "select * from Autor "
					+ "order by nome";
			
			PreparedStatement ps = getConexao().
					prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Autor a;
			while (rs.next()) {
				a = new Autor();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setNacionalidade(rs.getString("nacionalidade"));
				
				lista.add(a);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	public void incluir(Autor autor) {
		 try{
		String sql = "insert into autor (nome,nacionalidade) "
                + "values (?,?)";
		 PreparedStatement ps = getConexao().prepareStatement(sql);
		 ps.setString(1, autor.getNome());
        ps.setString(2, autor.getNacionalidade());
        
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
           String sql = "delete from autor where id = ?";
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
	public Autor buscar(long id) {
       Autor a = new Autor ();
       
       try {
           String sql = "SELECT * FROM autor al"
                        + " where al.id = ?";
           PreparedStatement ps = getConexao()
                   .prepareStatement(sql);
           ps.setLong(1, id);
           ResultSet rs = ps.executeQuery();
           if (rs.next()){
              a.setId(rs.getInt("id"));
              a.setNome(rs.getString("nome"));
              a.setNacionalidade(rs.getString("nacionalidade"));
           }
      
       } catch(SQLException e) {
           e.printStackTrace();
       } finally {
           fecharConexao();
       }
       
       return a;
   }
	 public void alterar(Autor a) {

	        try {
	            String sql = "update autor set "
	                    + " nome = ?, "
	                    + " nacionalidade = ? "
	                    + " where id = ?";

	            PreparedStatement ps = getConexao()
	                    .prepareStatement(sql);
	            ps.setString(1, a.getNome());
	            ps.setString(2, a.getNacionalidade());
	            ps.setLong(3, a.getId());
	            ps.execute();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	 }
}
