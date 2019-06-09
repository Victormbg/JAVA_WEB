package br.com.livraria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.Livros;

public class livroDAO extends conexao {

	public List<Livros> listar() {
		List<Livros> lista = new ArrayList<Livros>();
		try {
			String sql = "select * from livro "
					+ "order by titulo";
			
			PreparedStatement ps = getConexao().
					prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Livros l;
			while (rs.next()) {
				l = new Livros();
				l.setId(rs.getInt("id"));
				l.setTitulo(rs.getString("titulo"));
				l.setAno(rs.getInt("ano"));
				l.setISBN(rs.getInt("ISBN"));
				l.setEditora(rs.getString("editora"));
				l.setAutores(rs.getString("autores"));
				lista.add(l);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void incluir(Livros livro) {
		 try{
		String sql = "insert into livro (ISBN, titulo, ano, editora, autores) "
                 + "values (?,?,?,?,?)";
		 PreparedStatement ps = getConexao().prepareStatement(sql);
		 ps.setString(1, livro.getEditora());
         ps.setString(2, livro.getAutores());
         ps.setInt(3, livro.getAno());
         ps.setInt(4, livro.getISBN());
         ps.setString(5, livro.getTitulo());
         
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
            String sql = "delete from livro where id = ?";
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
	public Livros buscar(long id) {
        Livros l = new Livros ();
        
        try {
            String sql = "SELECT * FROM livro al"
                         + " where al.id = ?";
            PreparedStatement ps = getConexao()
                    .prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
            	l.setId(rs.getInt("id"));
				l.setTitulo(rs.getString("titulo"));
				l.setAno(rs.getInt("ano"));
				l.setISBN(rs.getInt("ISBN"));
				l.setEditora(rs.getString("editora"));
				l.setAutores(rs.getString("autores"));
            }
       
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return l;
    }
	 public void alterar(Livros l) {

	        try {
	            String sql = "update livro set "
	                    + " titulo = ?, "
	                    + " ano = ?, "
	                    + " ISBN = ?, "
	                    + " editora = ?, "
	                    + " autores = ? "
	                    + " where id = ?";

	            PreparedStatement ps = getConexao()
	                    .prepareStatement(sql);
	            ps.setInt(1, l.getISBN());
	            ps.setString(2, l.getTitulo());
	            ps.setInt(3, l.getAno());
	            ps.setString(4, l.getAutores());
	            ps.setString(5, l.getEditora());
	            ps.setLong(6, l.getId());
	            ps.execute();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	 }
}
