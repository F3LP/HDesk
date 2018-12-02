package view;

import controller.InvocaTelaDetalhes;
import controller.InvocaTelaValidacao;
import controller.PreencheTabela;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Chamado;
import model.Funcionario;
import model.Tecnico;
import model.dao.ChamadoDao;

public class TelaInicialTecnico extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PreencheTabela preTab;
	long prot = 0;
	boolean erro = true;
	int linha;

	TelaHistoricoTec telaHist;
	Funcionario autenticado = new Tecnico();

	public TelaInicialTecnico(Funcionario autenticado) {
		this.autenticado = autenticado;
		initComponents();
		preTab = new PreencheTabela();
		preTab.preencheTabelaTecnico(tabela, autenticado);
		setIconImage(new ImageIcon(getClass().getResource("/imagens/HDesk.png")).getImage());
		setLocationRelativeTo(null);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lblHistorico = new javax.swing.JLabel();
        btnAtender = new javax.swing.JButton();
        btnDetalhes = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCadUsuario = new javax.swing.JButton();
        btnValidar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Help Desk University");
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(152, 202, 239));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Chamados Abertos");

        tabela.setAutoCreateRowSorter(true);
        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Protocolo", "Dt Abertura", "Urgência", "Tipo", "Solicitante", "Departamento", "Título", "Téc. Responsável"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tabela);

        lblHistorico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblHistorico.setForeground(new java.awt.Color(0, 51, 255));
        lblHistorico.setText("> Histórico de Chamados");
        lblHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoricoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHistoricoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHistoricoMouseExited(evt);
            }
        });

        btnAtender.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAtender.setText("Atender");
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });

        btnDetalhes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDetalhes.setText("Ver Detalhes");
        btnDetalhes.setMaximumSize(new java.awt.Dimension(75, 23));
        btnDetalhes.setMinimumSize(new java.awt.Dimension(75, 23));
        btnDetalhes.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Bem vindo, " + autenticado.getNome() + ".");

        btnCadUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCadUsuario.setText("Cadastrar Usuário");
        btnCadUsuario.setMaximumSize(new java.awt.Dimension(75, 23));
        btnCadUsuario.setMinimumSize(new java.awt.Dimension(75, 23));
        btnCadUsuario.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadUsuarioActionPerformed(evt);
            }
        });

        btnValidar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnValidar.setText("Validar");
        btnValidar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnValidar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnValidar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(lblHistorico))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(btnAtender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAtender, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(btnCadUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(lblHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesActionPerformed
        InvocaTelaDetalhes telaDetal = new InvocaTelaDetalhes(this, tabela);
    }//GEN-LAST:event_btnDetalhesActionPerformed

	private void lblHistoricoMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHistoricoMouseEntered
		lblHistorico.setForeground(Color.CYAN);
	}// GEN-LAST:event_lblHistoricoMouseEntered

	private void lblHistoricoMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHistoricoMouseExited
		lblHistorico.setForeground(Color.BLUE);
	}// GEN-LAST:event_lblHistoricoMouseExited

	private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSairActionPerformed
		System.exit(0);
	}// GEN-LAST:event_btnSairActionPerformed

	private void lblHistoricoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHistoricoMouseClicked
		telaHist = new TelaHistoricoTec(this, rootPaneCheckingEnabled, autenticado);
		telaHist.preTabela.preencheTabelaHistoricoTec(tabela, autenticado);
		dispose();
		telaHist.setVisible(true);
	}// GEN-LAST:event_lblHistoricoMouseClicked

	private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnValidarActionPerformed
		InvocaTelaValidacao telaVal = new InvocaTelaValidacao(tabela, this, autenticado);

	}// GEN-LAST:event_btnValidarActionPerformed

	private void btnCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCadUsuarioActionPerformed
		dispose();
		new TelaCadUsuario(this, true).setVisible(true);
	}// GEN-LAST:event_btnCadUsuarioActionPerformed


	private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAtenderActionPerformed
		try {
			linha = tabela.getSelectedRow();
			prot = (long) tabela.getModel().getValueAt(linha, 1);
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Selecione um chamado.");
			erro = false;
		}
		
		if (erro != false) {
		Chamado chamado = new Chamado();
		chamado.setDtAtendimento(Calendar.getInstance());
		new ChamadoDao().atualizaAtender(autenticado, prot, chamado);
		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Status", "Protocolo",
				"Data de Abertura", "Urgência", "Tipo", "Solicitante", "Departamento", "Título", "Téc. Responsável" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		preTab.preencheTabelaTecnico(tabela, autenticado);
		}
                                          

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaInicialTecnico.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaInicialTecnico.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaInicialTecnico.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaInicialTecnico.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtender;
    private javax.swing.JButton btnCadUsuario;
    private javax.swing.JButton btnDetalhes;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHistorico;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
