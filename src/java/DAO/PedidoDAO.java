package DAO;

import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO
{
    private PreparedStatement opListar;
    private PreparedStatement opNovo;
    private PreparedStatement opAtualizar;
    
    public PedidoDAO() throws Exception
    {
        Connection conexao = ConnectionFactory.createConnection();
        opListar = conexao.prepareStatement("SELECT * FROM pedido");
        opNovo = conexao.prepareStatement("INSERT INTO pedido(nome, pedido, dono, valor) VALUES (?,?,?,?)");
        opAtualizar = conexao.prepareStatement("UPDATE pedido set pedido = ?, dono = ?, valor = ?, nome = ? WHERE id = ?");
    }

    public List<Pedido> listAll() throws Exception
    {
        try {
            List<Pedido> pedidos = new ArrayList<>();

            ResultSet resultado = opListar.executeQuery();
            while (resultado.next()) {
                Pedido novoPedido = new Pedido();
                novoPedido.setId(resultado.getLong("id"));
                novoPedido.setPedido(resultado.getInt("pedido"));
                novoPedido.setDono(resultado.getString("dono"));
                novoPedido.setValor(resultado.getFloat("valor"));
                novoPedido.setNome(resultado.getString("nome"));
                novoPedido.setAtualizacao(resultado.getDate("atualizacao"));
                pedidos.add(novoPedido);
            }

            return pedidos;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar os pedidos no banco!", ex);
        }
    }
    
    public void update(Pedido Pedido) throws Exception
    {
        try
        {
            opAtualizar.clearParameters();
            opAtualizar.setString(1, Pedido.getNome());
            opAtualizar.setLong(4, Pedido.getId());
            opAtualizar.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new Exception("Erro ao atualizar o oedudi!", ex);
        }
    }

    public void cria(Pedido novoPedido) throws Exception
    {
        try
        {
            opNovo.clearParameters();
            opNovo.setString(1,novoPedido.getNome());
            opNovo.setFloat(2, novoPedido.getPedido());
            opNovo.setString(3, novoPedido.getDono());
            opNovo.setFloat(4, novoPedido.getValor());
            opNovo.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new Exception("Erro ao inserir o pedido: "+ex.getMessage());
        }

    }
}
