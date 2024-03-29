/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Presentation.Desktop;

import br.edu.ifnmg.Mercearia.DomainModel.Compra;
import br.edu.ifnmg.Mercearia.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Mercearia.DomainModel.Fornecedor;
import br.edu.ifnmg.Mercearia.DomainModel.Produto;
import br.edu.ifnmg.Mercearia.Persistence.CompraRepositorio;
import br.edu.ifnmg.Mercearia.Persistence.FornecedorRepositorio;
import br.edu.ifnmg.Mercearia.Persistence.ProdutoRepositorio;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larisse
 */
public class CompraRegistrar extends javax.swing.JInternalFrame {

    private FornecedorRepositorio forn_repo;
    private ProdutoRepositorio prod_repo;
    private Compra compra;
    private CompraRepositorio repositorio;
    private Produto filtro;
    /**
     * Creates new form CompraRegistrar
     */
    public CompraRegistrar(Compra compra, CompraRepositorio repo) {
        initComponents();
        this.compra = compra;
        this.repositorio = repo;
        compra = new Compra();
        prod_repo = new ProdutoRepositorio();
        //forn_repo = new FornecedorRepositorio(); 
        filtro = new Produto();
        
        List<Produto> produtos = prod_repo.Buscar(null);
        ComboBoxModel <Produto> model_produtos
                = new DefaultComboBoxModel<>(new Vector(produtos));
        cbxProduto.setModel(model_produtos);
        
       /* List<Fornecedor> fornecedores = forn_repo.Buscar(null);
        ComboBoxModel<Fornecedor> model_fornecedores =
                  new DefaultComboBoxModel<>(new Vector(fornecedores));
          cbxFornecedores.setModel(model_fornecedores);   */     
          setCompra(compra);
        
    }
    
     public CompraRegistrar() {
        initComponents();
        this.compra = compra;
        this.repositorio = repositorio;
        compra = new Compra();
        prod_repo = new ProdutoRepositorio();
        forn_repo = new FornecedorRepositorio(); 
        filtro = new Produto();
        
        List<Produto> produtos = prod_repo.Buscar(null);
        ComboBoxModel <Produto> model_produtos
                = new DefaultComboBoxModel<>(new Vector(produtos));
        cbxProduto.setModel(model_produtos);
       
         
         
       List<Fornecedor> fornecedores = forn_repo.Buscar(null);
       ComboBoxModel<Fornecedor> model_fornecedores =
                  new DefaultComboBoxModel<>(new Vector(fornecedores));
        cbxFornecedores.setModel(model_fornecedores);
//        setCompra(compra);
        
    }

    public Compra getCompra()throws ErroValidacaoException {
        this.compra = compra;
        compra.setFornecedor((Fornecedor)cbxFornecedores.getSelectedItem());
        this.compra.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        return compra;
    }
    
    public void setCompra(Compra compra){
        this.compra = compra;
        cbxFornecedores.setSelectedItem(compra.getFornecedor());
        txtQuantidade.setText(String.valueOf(compra.getQuantidade()));
        PreencherTabelaInfo(compra.getProdutos());
       
        
    }
    
     private void PreencherTabelaInfo(List<Produto> produtos){
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

        tabProdutos.setModel(modelo);
       
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabProdutos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxFornecedores = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnCliente = new javax.swing.JMenuItem();
        mnFornecedor = new javax.swing.JMenuItem();
        mnProduto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnBuscarProduto = new javax.swing.JMenuItem();
        mnRegistros = new javax.swing.JMenu();
        mnRegistrarCompra = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setTitle("Registro de compra");
        setPreferredSize(new java.awt.Dimension(648, 565));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Registro de compras");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Larisse\\Desktop\\POO\\prop50.jpg")); // NOI18N

        jLabel3.setText("Produto:");

        jLabel4.setText("Quantidade:");

        btnSalvar.setText("Salvar compra");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAdd.setText("Adicionar item");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tabProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabProdutos);

        jLabel6.setText("Valor total:");

        jLabel5.setText("Fonecedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(98, 98, 98)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxFornecedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(btnAdd))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbxFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addGap(50, 50, 50))
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

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Produto");

        mnBuscarProduto.setText("Buscar");
        mnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBuscarProdutoActionPerformed(evt);
            }
        });
        jMenu3.add(mnBuscarProduto);

        jMenuBar1.add(jMenu3);

        mnRegistros.setText("Registros");

        mnRegistrarCompra.setBackground(new java.awt.Color(204, 204, 255));
        mnRegistrarCompra.setText("Registrar compra");
        mnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRegistrarCompraActionPerformed(evt);
            }
        });
        mnRegistros.add(mnRegistrarCompra);

        jMenuBar1.add(mnRegistros);

        jMenu2.setText("Sistema");

        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });
        jMenu2.add(mnSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void mnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBuscarProdutoActionPerformed
        // TODO add your handling code here:
        ProdutoBuscar  tela = new ProdutoBuscar();
        this.getParent().add(tela);
        tela.show();
        dispose();
    }//GEN-LAST:event_mnBuscarProdutoActionPerformed

    private void mnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRegistrarCompraActionPerformed
        // TODO add your handling code here:
        CompraRegistrar tela = new CompraRegistrar();
        this.getParent().add(tela);
        tela.show();
        dispose();
    }//GEN-LAST:event_mnRegistrarCompraActionPerformed

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        // TODO add your handling code here:
        LoginUsuario tela = new LoginUsuario();
        this.getParent().add(tela);
        tela.show();
        dispose();
    }//GEN-LAST:event_mnSairActionPerformed

    private void tabProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutosMouseClicked
        // TODO add your handling code here:
        int linha = this.tabProdutos.getSelectedRow();
        int id = Integer.parseInt(this.tabProdutos.getValueAt(linha, 2).toString() );
        Compra compra =  repositorio.Abrir(id);
        

       
    }//GEN-LAST:event_tabProdutosMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        Produto produto = (Produto)cbxProduto.getSelectedItem();
        int quantidade = Integer.parseInt(this.txtQuantidade.getText());
        //Fornecedor fornecedor = (Fornecedor)cbxFornecedores.getSelectedItem();
        this.compra.addProduto(produto,quantidade);
        this.txtValorTotal.setText(String.valueOf(this.compra.getValorTotal()));
    
        PreencherTabelaInfo(this.compra.getProdutos());
               
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        try {
            Compra compra;
            compra = getCompra();
            if( JOptionPane.showConfirmDialog(null, "Salvar compra?", 
                    "Confirmar", JOptionPane.YES_NO_OPTION) == 0) {
                if(this.repositorio.Salvar(compra))
                    JOptionPane.showMessageDialog(null, "Compra salva com sucesso!");
                else
                    JOptionPane.showMessageDialog(null, "Falha ao salvar os dados! Consulte o administrador do sistema.");

            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        } catch (ErroValidacaoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Fornecedor> cbxFornecedores;
    private javax.swing.JComboBox<Produto> cbxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mnBuscarProduto;
    private javax.swing.JMenuItem mnCliente;
    private javax.swing.JMenuItem mnFornecedor;
    private javax.swing.JMenuItem mnProduto;
    private javax.swing.JMenuItem mnRegistrarCompra;
    private javax.swing.JMenu mnRegistros;
    private javax.swing.JMenuItem mnSair;
    private javax.swing.JTable tabProdutos;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
