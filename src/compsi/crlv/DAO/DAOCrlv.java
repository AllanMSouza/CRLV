/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.DAO;

import compsi.crlv.model.ModelCRLV;
import compsi.crlv.model.ModelIPVA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author allan
 */
public class DAOCrlv extends Database {
    
    private Connection con = null;
    
    public int insert(ModelCRLV crlv) throws ClassNotFoundException, SQLException{
        int result;     
        con = abrirBanco(con);
        
        String sql = "insert into crlv"
                + "(via, cod_renavam, rntrc, exercicio, nome, cpf_cnpj, placa,"
                + "uf_placa, placa_ant, uf_placa_ant, chassi, especie_tipo, combustivel,"
                + "marca, modelo, ano_fab, ano_mod, cap, pot, cil, categoria, cor, premio_tarifario,"
                + "iof, premio_total, data_pagamento, observacoes, local, data)"
                + "values"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, crlv.getVia());
        stm.setString(2, crlv.getCodRenavam());
        stm.setString(3, crlv.getRntrc());
        stm.setString(4, crlv.getExercicio());
        stm.setString(5, crlv.getNome());
        stm.setString(6, crlv.getCpfCnpj());
        stm.setString(7, crlv.getPlaca());
        stm.setString(8, crlv.getUfPlaca());
        stm.setString(9, crlv.getPlacaAnt());
        stm.setString(10, crlv.getUfPlacaAnt());
        stm.setString(11, crlv.getChassi());
        stm.setString(12, crlv.getEspecieTipo());
        stm.setString(13, crlv.getCombustivel());
        stm.setString(14, crlv.getMarca());
        stm.setString(15, crlv.getModelo());
        stm.setInt(16, crlv.getAnoFab());
        stm.setInt(17, crlv.getAnoMod());
        stm.setString(18, crlv.getCap());
        stm.setString(19, crlv.getPot());
        stm.setString(20, crlv.getCil());
        stm.setString(21, crlv.getCategoria());
        stm.setString(22, crlv.getCor());
        stm.setString(23, crlv.getPremioTarifario());
        stm.setString(24, crlv.getIof());
        stm.setString(25, crlv.getPremioTotal());
        stm.setString(26, crlv.getDataPag());
        stm.setString(27, crlv.getObservacoes());
        stm.setString(28, crlv.getLocal());
        stm.setString(29, crlv.getData());
        
        result = stm.executeUpdate();
        int idCrlv = 0;
        
       ResultSet rs = selectIpva(crlv);
       if(rs.next())
          idCrlv = rs.getInt("id_crlv");
        
        sql = "insert into ipva "
                + "(cota_unica, venc_cota_unica, faixa_ipva, parcelamento_cotas,"
                + "venc_primeira_cota, venc_segunda_cota, venc_terceira_cota, crlv_id_crlv) "
                + "values "
                + "(?,?,?,?,?,?,?,?)";
        
        stm = con.prepareStatement(sql);
        stm.setString(1, crlv.getIpva().getCotaUnica());
        stm.setString(2, crlv.getIpva().getVencCotaUnica());
        stm.setString(3, crlv.getIpva().getFaixaIpva());
        stm.setString(4, crlv.getIpva().getParcelamentoCotas());
        stm.setString(5, crlv.getIpva().getVencPrimeiraCota());
        stm.setString(6, crlv.getIpva().getVencSegundaCota());
        stm.setString(7, crlv.getIpva().getVencTerceiraCota());
        stm.setInt(8, idCrlv);
//        System.out.println(idCrlv);
        result = stm.executeUpdate();
        fecharBanco(con);
        
        return result;
    }
    
    private ResultSet selectIpva(ModelCRLV crlv) throws SQLException{
       
//        testarConexao(con);
        
        ResultSet rs = null;
        
        String sql = "select * from crlv "
                + "where cod_renavam = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, crlv.getCodRenavam());
        rs = stm.executeQuery();
        
        return rs;
    }
    
    public int update(ModelCRLV crlv) throws ClassNotFoundException, ClassNotFoundException, SQLException{
       int result;
//        System.out.println("id_crlv = " + crlv.getIdCrlv());
        con = abrirBanco(con);
        
        String sql = "update crlv set "
                + "via = ?, cod_renavam = ?, rntrc = ?, exercicio = ?, nome = ?, cpf_cnpj = ?, placa = ?,"
                + "uf_placa = ?, placa_ant = ?, uf_placa_ant = ?, chassi = ?, especie_tipo = ?, combustivel = ?,"
                + "marca = ?, modelo = ?, ano_fab = ?, ano_mod = ?, cap = ?, pot = ?, cil = ?, categoria = ?, cor = ?, premio_tarifario = ?,"
                + "iof = ?, premio_total = ?, data_pagamento = ?, observacoes = ?, local = ?, data = ?"
                + " where id_crlv = ?";
        
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, crlv.getVia());
        stm.setString(2, crlv.getCodRenavam());
        stm.setString(3, crlv.getRntrc());
        stm.setString(4, crlv.getExercicio());
        stm.setString(5, crlv.getNome());
        stm.setString(6, crlv.getCpfCnpj());
        stm.setString(7, crlv.getPlaca());
        stm.setString(8, crlv.getUfPlaca());
        stm.setString(9, crlv.getPlacaAnt());
        stm.setString(10, crlv.getUfPlacaAnt());
        stm.setString(11, crlv.getChassi());
        stm.setString(12, crlv.getEspecieTipo());
        stm.setString(13, crlv.getCombustivel());
        stm.setString(14, crlv.getMarca());
        stm.setString(15, crlv.getModelo());
        stm.setInt(16, crlv.getAnoFab());
        stm.setInt(17, crlv.getAnoMod());
        stm.setString(18, crlv.getCap());
        stm.setString(19, crlv.getPot());
        stm.setString(20, crlv.getCil());
        stm.setString(21, crlv.getCategoria());
        stm.setString(22, crlv.getCor());
        stm.setString(23, crlv.getPremioTarifario());
        stm.setString(24, crlv.getIof());
        stm.setString(25, crlv.getPremioTotal());
        stm.setString(26, crlv.getDataPag());
        stm.setString(27, crlv.getObservacoes());
        stm.setString(28, crlv.getLocal());
        stm.setString(29, crlv.getData());
        stm.setInt(30, crlv.getIdCrlv());
        
        result = stm.executeUpdate();
        //System.out.println(result);
        if(result == 1){
//            System.out.println("update tabela ipva = " +crlv.getIpva().getIdIpva());
            sql = "update ipva set "
                    + "cota_unica = ?, venc_cota_unica = ?, faixa_ipva = ?, parcelamento_cotas = ?,"
                + "venc_primeira_cota = ?, venc_segunda_cota = ?, venc_terceira_cota = ? "
                    + " where id_ipva = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, crlv.getIpva().getCotaUnica());
            stm.setString(2, crlv.getIpva().getVencCotaUnica());
            stm.setString(3, crlv.getIpva().getFaixaIpva());
            stm.setString(4, crlv.getIpva().getParcelamentoCotas());
            stm.setString(5, crlv.getIpva().getVencPrimeiraCota());
            stm.setString(6, crlv.getIpva().getVencSegundaCota());
            stm.setString(7, crlv.getIpva().getVencTerceiraCota());
            stm.setInt(8, crlv.getIdCrlv());
            stm.setInt(8, crlv.getIpva().getIdIpva());
            
            result = stm.executeUpdate();
            fecharBanco(con);
        }
        
        return result;
    }
    
    private LinkedList<ModelCRLV> fetchAll() throws SQLException, ClassNotFoundException{
        LinkedList<ModelCRLV> crlvs = new LinkedList<ModelCRLV>();
        con = abrirBanco(con);
        
        String sql = "select * from crlv inner join ipva "
                + "on (id_crlv = crlv_id_crlv)";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while(rs.next() == true){
            ModelCRLV crlv = new ModelCRLV();
            ModelIPVA ipva = new ModelIPVA();
            
            crlv.setIdCrlv(rs.getInt("id_crlv"));
            crlv.setVia(rs.getInt("via"));
            crlv.setCodRenavam(rs.getString("cod_renavam"));
            crlv.setRntrc(rs.getString("rntrc"));
            crlv.setExercicio(rs.getString("exercicio"));
            crlv.setNome(rs.getString("Nome"));
            crlv.setCpfCnpj(rs.getString("cpf_cnpj"));
            crlv.setPlaca(rs.getString("placa"));
            crlv.setUfPlaca(rs.getString("uf_placa"));
            crlv.setPlacaAnt(rs.getString("placa_ant"));
            crlv.setUfPlacaAnt(rs.getString("uf_placa_ant"));
            crlv.setChassi(rs.getString("chassi"));
            crlv.setEspecieTipo(rs.getString("especie_tipo"));
            crlv.setCombustivel(rs.getString("combustivel"));
            crlv.setMarca(rs.getString("marca"));
            crlv.setModelo(rs.getString("modelo"));
            crlv.setAnoFab(rs.getInt("ano_fab"));
            crlv.setAnoMod(rs.getInt("ano_mod"));
            crlv.setCap(rs.getString("cap"));
            crlv.setPot(rs.getString("pot"));
            crlv.setCil(rs.getString("cil"));
            crlv.setCategoria(rs.getString("categoria"));
            crlv.setCor(rs.getString("cor"));
//            crlv.getIpva().setIdIpva(rs.getInt("id_ipva"));
            ipva.setIdIpva(rs.getInt("id_ipva"));
            ipva.setCotaUnica(rs.getString("cota_unica"));
            ipva.setFaixaIpva(rs.getString("faixa_ipva"));
            ipva.setVencCotaUnica(rs.getString("venc_cota_unica"));
            ipva.setParcelamentoCotas(rs.getString("parcelamento_cotas"));
            ipva.setVencPrimeiraCota(rs.getString("venc_primeira_cota"));
            ipva.setVencSegundaCota(rs.getString("venc_segunda_cota"));
            ipva.setVencTerceiraCota(rs.getString("venc_terceira_cota"));
            crlv.setIpva(ipva);
            crlv.setPremioTarifario(rs.getString("premio_tarifario"));
            crlv.setIof(rs.getString("iof"));
            crlv.setPremioTotal(rs.getString("premio_total"));
            crlv.setDataPag(rs.getString("data_pagamento"));
            crlv.setObservacoes(rs.getString("observacoes"));
            crlv.setLocal(rs.getString("local"));
            crlv.setData(rs.getString("data"));
            
            crlvs.add(crlv);
        }
        fecharBanco(con);
        return crlvs;
    }
    
    public LinkedList<ModelCRLV> getListCrlvs() throws SQLException, ClassNotFoundException{
        return fetchAll();
    }
    
    public int destroy(int idCrlv) throws ClassNotFoundException, ClassNotFoundException, SQLException{
        int result;
        con = abrirBanco(con);
        PreparedStatement stm;
        String sql = "delete from ipva where crlv_id_crlv = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, idCrlv);
        result = stm.executeUpdate();
        
        if(result == 1){
            sql = "delete from crlv where id_crlv = ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, idCrlv);
            result = stm.executeUpdate();
        }
        
        return result;
    }
    

        
}
