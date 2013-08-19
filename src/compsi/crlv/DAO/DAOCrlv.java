/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.DAO;

import compsi.crlv.model.CRLV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author allan
 */
public class DAOCrlv extends Database {
    
    public void insert(CRLV crlv) throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        abrirBanco(con);
        
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
        
        boolean result = stm.execute();
        
        ResultSet rs = select(crlv);
        int idCrlv = rs.getInt("id_crlv");
        
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
        
        result = stm.execute();
        fecharBanco(con);
    }
    
    private ResultSet select(CRLV crlv) throws SQLException{
        Connection con = null;
        ResultSet rs = null;
        
        String sql = "select * from crlv "
                + "where cod_renavam = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, crlv.getCodRenavam());
        rs = stm.executeQuery();
        
        return rs;
    }
    

        
}
