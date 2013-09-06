package br.com.view;

import br.com.controller.ClienteController;
import br.com.controller.CompraController;
import br.com.model.negocio.Cliente;
import br.com.model.negocio.Compra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mayara_freita
 */
public class JanelaAtualizarCompra extends javax.swing.JFrame {

    CompraTableModel model;
    int linhaSelecionada;
    int codigoCliente;
    

    /**
     * Creates new form JanelaCliente
     */
  

    public JanelaAtualizarCompra(int selecionado, Integer cdCompra, CompraTableModel ctm) {
       initComponents();
       campoId.setEditable(false);
       linhaSelecionada = selecionado;
       codigoCliente = cdCompra;
        model = ctm;
        
        
        CompraController cc = new CompraController();
        Compra c = new Compra();
        c = cc.listarCompraById(cdCompra);
        
        campoId.setText(Integer.toString(c.getId()));
        campoProduto.setText(c.getProduto());
        carregarCombo(c.getCliente().getId());
        campoTotalCompra.setText(c.getTotalCompra());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        painelFundo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        labelProduto = new javax.swing.JLabel();
        campoProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTotalCompra = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        combCliente = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));
        painelFundo.setLayout(null);

        labelTitulo.setText("Compra");
        painelFundo.add(labelTitulo);
        labelTitulo.setBounds(118, 11, 70, 30);

        labelId.setText("Id: ");
        painelFundo.add(labelId);
        labelId.setBounds(27, 76, 50, 23);
        painelFundo.add(campoId);
        campoId.setBounds(103, 77, 41, 20);

        labelProduto.setText("Produto: ");
        painelFundo.add(labelProduto);
        labelProduto.setBounds(27, 105, 66, 27);
        painelFundo.add(campoProduto);
        campoProduto.setBounds(97, 108, 167, 20);

        jLabel1.setText("Cliente:");
        painelFundo.add(jLabel1);
        jLabel1.setBounds(27, 138, 66, 31);

        jLabel2.setText("Total Compra:");
        painelFundo.add(jLabel2);
        jLabel2.setBounds(27, 180, 82, 30);
        painelFundo.add(campoTotalCompra);
        campoTotalCompra.setBounds(113, 185, 88, 20);

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        painelFundo.add(botaoSalvar);
        botaoSalvar.setBounds(276, 216, 71, 31);

        combCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        painelFundo.add(combCliente);
        combCliente.setBounds(100, 140, 160, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        Compra c = new Compra();
        if (campoId.getText().length() > 0) {
            c.setId(Integer.parseInt(campoId.getText()));
            c.setProduto(campoProduto.getText());
             c.setCliente((Cliente)combCliente.getSelectedItem());
            c.setTotalCompra(campoTotalCompra.getText());



            CompraController cc = new CompraController();
            if (cc.salvar(c)) {
                model.updateCompra(linhaSelecionada, c);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Insira o nome da marca");
        }








    }//GEN-LAST:event_botaoSalvarActionPerformed

    private Compra pesquisar(String produto) {
        CompraController cc = new CompraController();
        return cc.listarCompraByProd(produto);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoProduto;
    private javax.swing.JTextField campoTotalCompra;
    private javax.swing.JComboBox combCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelFundo;
    // End of variables declaration//GEN-END:variables
 private void carregarCombo(int cdCompra) {
         //assim como é feito numa JTable, temos o DefaultComboBoxModel que é o model do JComboBox
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) combCliente.getModel();
        //removendo todos os elementos do combo
        comboModel.removeAllElements();
        //cria a lista: java.util.List
        List<Cliente> marcas = new ArrayList<Cliente>();
        ClienteController a = new ClienteController();
        marcas = a.listarCliente();
        
     
        for (int linha = 0; linha < marcas.size(); linha++) {
            //pegando a categoria da lista
            Cliente marca = marcas.get(linha);
            //adicionando a categoria no combo
            comboModel.addElement(marca);
            if ( marca.getId() == cdCompra){
                comboModel.setSelectedItem(marca);
            }
            
        }
        
    }
    



}
