/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.util.List;

import javax.swing.JOptionPane;
import model.Chamado;
import model.dao.ChamadoDao;

/**
 *
 * @author Felipe
 */
public class TestaGetLisProt {
    public static void main(String[] args){
        
        long prot = 11;
        ChamadoDao dao = new ChamadoDao();
        Chamado chamad = dao.getChamadoProt(prot);
        
        System.out.println(chamad.getProtocolo());

    }
}
