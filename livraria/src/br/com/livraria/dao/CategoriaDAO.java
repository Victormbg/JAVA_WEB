package br.com.livraria.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.livraria.Categoria;

public class CategoriaDAO extends Conexao {

	public List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			String sql = "select * from Categoria "
					+ "order by codigo";
			
			PreparedStatement ps = getConexao().
					prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Categoria c;
			while (rs.next()) {
				c = new Categoria();
				c.setId(rs.getInt("id"));
				c.setCodigo(rs.getString("codigo"));
				c.setDescricao(rs.getString("descricao"));
				
				lista.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	public void incluir(Categoria categoria) {
		 try{
		String sql = "insert into categoria (codigo,Descricao) "
                + "values (?,?)";
		 PreparedStatement ps = getConexao().prepareStatement(sql);
		 ps.setString(1, categoria.getCodigo());
        ps.setString(2, categoria.getDescricao());
        
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
           String sql = "delete from categoria  where id = ?";
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
	public Categoria buscar(long id) {
       Categoria c = new Categoria ();
       
       try {
           String sql = "SELECT * FROM categoria al"
                        + " where al.id = ?";
           PreparedStatement ps = getConexao()
                   .prepareStatement(sql);
           ps.setLong(1, id);
           ResultSet rs = ps.executeQuery();
           if (rs.next()){
              c.setId(rs.getInt("id"));
              c.setCodigo(rs.getString("codigo"));
              c.setDescricao(rs.getString("descricao"));
             
           }
      
       } catch(SQLException e) {
           e.printStackTrace();
       } finally {
           fecharConexao();
       }
       
       return c;
   }
	 public void alterar(Categoria c) {

	        try {
	            String sql = "update categoria set "
	                    + " codigo = ?, "
	                    + " descricao = ? "
	                    + " where id = ?";

	            PreparedStatement ps = getConexao()
	                    .prepareStatement(sql);
	            ps.setString(1, c.getCodigo());
	            ps.setString(2, c.getDescricao());
	            ps.setLong(3, c.getId());
	            ps.execute();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	 }
}
