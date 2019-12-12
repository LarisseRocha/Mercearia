/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Presentation.Desktop;

import br.edu.ifnmg.Mercearia.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Mercearia.DomainModel.Produto;
import br.edu.ifnmg.Mercearia.Persistence.ProdutoRepositorio;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larisse
 */
public class ProdutoBuscar extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProdutoBuscar
     */
     ProdutoRepositorio repositorio;
     Produto filtro;
    public ProdutoBuscar() {
        initComponents();
        repositorio = new ProdutoRepositorio();
        filtro = new Produto();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnCliente = new javax.swing.JMenuItem();
        mnFornecedor = new javax.swing.JMenuItem();
        mnProduto = new javax.swing.JMenuItem();
        mnRegistrarCompra = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnBuscarProduto = new javax.swing.JMenuItem();

        jLabel2.setText("jLabel2");

        setClosable(true);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setText("Produto:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descricao", "Unidade compra", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabResultado);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Buscar Produto");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Larisse\\Desktop\\POO\\prop50.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

        jMenu1.setBackground(java.awt.Color.white);
        jMenu1.setText("Cadastros");

        mnCliente.setText("Cliente");
        mnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnCliente);

        mnFornecedor.setText("Fornecedor");
        mnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnFornecedorActionPerformed(evt);
            }
        });
        jMenu1.add(mnFornecedor);

        mnProduto.setText("Produto");
        mnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(mnProduto);

        mnRegistrarCompra.setBackground(new java.awt.Color(204, 204, 255));
        mnRegistrarCompra.setText("Registrar compra");
        mnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRegistrarCompraActionPerformed(evt);
            }
        });
        jMenu1.add(mnRegistrarCompra);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sistema");

        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });
        jMenu2.add(mnSair);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Produto");

        mnBuscarProduto.setText("Buscar");
        mnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBuscarProdutoActionPerformed(evt);
            }
        });
        jMenu3.add(mnBuscarProduto);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaProdutos(List<Produto> produtos){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("descricao");
        modelo.addColumn("uniCompra");
        modelo.addColumn("valor");
        
        
        for(Produto p : produtos){
            Vector linha = new Vector();
            linha.add(p.getId());
            linha.add(p.getDescricao());
            linha.add(p.getUniCompra());
            linha.add(p.getPrCompra());
            modelo.addRow(linha);
        }
       
        tabResultado.setModel(modelo);
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         // TODO add your handling code here:
         filtro = new Produto();
         if(txtDescricao.getText().length()>0)
             filtro.setDescricao(txtDescricao.getText());
        List<Produto> produto = repositorio.Buscar(filtro);
        TabelaProdutos(produto);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tabResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoMouseClicked
        // TODO add your handling code here:
        
        int linha = this.tabResultado.getSelectedRow();
        int id = Integer.parseInt(this.tabResultado.getValueAt(linha, 2).toString() );
        Produto produto =  repositorio.Abrir(id);
        
    }//GEN-LAST:event_tabResultadoMouseClicked

    private void mnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnClienteActionPerformed
        // TODO add your handling code here:
        ClienteEditar tela = new ClienteEditar();
        this.getParent().add(tela);
        tela.show();
        dispose();
    }//GEN-LAST:event_mnClienteActionPerformed

    private void mnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnFornecedorActionPerformed
        // TODO add your handling code here:
        FornecedorEditar tela = new FornecedorEditar();
        this.getParent().add(tela);
        tela.show();
        dispose();
    }//GEN-LAST:event_mnFornecedorActionPerformed

    private void mnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProdutoActionPerformed
        // TODO add your handling code here:
        ProdutoEditar tela = new ProdutoEditar();
        //System.out.println("aaaa");
        this.getParent().add(tela);
        tela.show();
        dispose();

    }//GEN-LAST:event_mnProdutoActionPerformed

    private void mnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRegistrarCompraActionPerformed
        // TODO add your handling code here:
        CompraEditar tela = new CompraEditar();
        this.getParent().add(tela);
        tela.show();
        dispose();
    }//GEN-LAST:event_mnRegistrarCompraActionPerformed

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        // TODO add your handling code here:
        TelaPrincipal tela = new TelaPrincipal();
        this.getParent().add(tela);
        tela.show();
        dispose();
    }//GEN-LAST:event_mnSairActionPerformed

    private void mnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBuscarProdutoActionPerformed
        // TODO add your handling code here:
        ProdutoBuscar  tela = new ProdutoBuscar();
        this.getParent().add(tela);
        tela.show();
        dispose();

    }//GEN-LAST:event_mnBuscarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnBuscarProduto;
    private javax.swing.JMenuItem mnCliente;
    private javax.swing.JMenuItem mnFornecedor;
    private javax.swing.JMenuItem mnProduto;
    private javax.swing.JMenuItem mnRegistrarCompra;
    private javax.swing.JMenuItem mnSair;
    private javax.swing.JTable tabResultado;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
